// Raymond Guevara Lozano
// Scott Sakurai
// Brent Nishioka
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**class to find fist found variation of input string along with line number*/
public class Search{
    
    /** Main method where ArrayList of strings is created and all strings are appended from the file,
     *  Linear search is then performed to find the string, then based on returned value, outputs appropriate
     *  answer.
     * @param args command line arguments for the program args[0]: name of file, args[1]: search string
     */
    public static void main(String[] args) {
        ArrayList<String> txtInput = new ArrayList<String>();
        readFile(txtInput, args);
        int n = linearSearch(txtInput, args[1]);
        if (n != -1){
            System.out.println("Found search string: " + txtInput.get(n-1));
            System.out.println("Line Number: " + n);
        }
        else{
            System.out.println("String not found");
        }
    }

    /** Method where the file is read in and appends all strings to ArrayList
     * @param strings Arraylist of strings that is where the strings from file will be appended to
     * @param args command line argument, only use the name of the file
     */
    public static void readFile(ArrayList<String> strings, String[] args){ 
        File inputFile = new File(args[0]);
        try{
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()){
                String line = input.nextLine();
                strings.add(line);
            }
            input.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /** Method to see if a string from file is a variation of the inputted string from commandline
     *  puts both strings in char arrays then sorts those arrays and returns if both arrays are equal or not
     * @param listString from file
     * @param usrString inputted from command line
     * @return boolean value as to both strings are variations of one another
     */
    public static boolean sameChars(String listString, String usrString) { 
        char[] txtString = listString.toLowerCase().toCharArray(); 
        char[] inputtedString = usrString.toLowerCase().toCharArray();
        Arrays.sort(txtString); // sort char arrays 
        Arrays.sort(inputtedString);
        return Arrays.equals(txtString, inputtedString); 
    }

    /** Linearly search through the ArrayList of strings that was made after reading file, compare each string 
     *  to string entered from command line and see if they are variations of one another
     * @param strings from file
     * @param string entered from command line
     * @return int line number of where string variation was found, -1 if nothing found
     */
    public static int linearSearch(ArrayList<String> strings, String string){ 
       int n = strings.size();
       for(int i = 0; i < n; i++){
           if (sameChars(strings.get(i), string)){
               return i + 1; 
           }
       }
       return -1; 
    }
}
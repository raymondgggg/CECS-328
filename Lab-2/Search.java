// Raymond Guevara Lozano
// Scott Sakurai
// Brent Nishioka
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Search{
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

    public static void readFile(ArrayList<String> strings, String[] args){ //method to read file and append all the strings to ArrayList
        File inputFile = new File(args[0]);
        try{
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()){
                String line = input.nextLine();
                strings.add(line);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static boolean sameChars(String listString, String usrString) { // method to compare if strings are equal
        char[] txtString = listString.toLowerCase().toCharArray(); //create char arrays of the two strings
        char[] inputtedString = usrString.toLowerCase().toCharArray();
        Arrays.sort(txtString); // sort char arrays 
        Arrays.sort(inputtedString);
        return Arrays.equals(txtString, inputtedString); // check if the chars in the arrays are equal
    }

    public static int linearSearch(ArrayList<String> strings, String string){ //searching for the string entered from command line through input.txt file
       int n = strings.size();
       for(int i = 0; i < n; i++){
           if (sameChars(strings.get(i), string)){
               return i + 1; //return the position of word in .txt file
           }
       }
       return -1; //return -1 if word is not found
    }
}
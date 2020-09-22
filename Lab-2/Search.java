
// Raymond Guevara Lozano
// Scott Sakurai
// Brent Nishioka
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        ArrayList<String> txtInput = new ArrayList<String>();
        readFile(txtInput, args);
        insertionSort(txtInput);
        for (int i = 0; i < txtInput.size(); i++){
            System.out.println(txtInput.get(i));
        }
        int n = binarySearch(txtInput, args[1]);
        System.out.println(n);

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

    public static void insertionSort(ArrayList<String> strings){
        for (int j = 1; j < strings.size(); j++){ //begininng loop to get 2nd element of array
            String key = strings.get(j);
            int i = j - 1;

            while (i >= 0 && ((strings.get(i).compareToIgnoreCase(key) > 0))){ //comparison of previous element(s)
                strings.set(i+1, strings.get(i));
                i = i -1;
            }
            strings.set(i+1, key);
        }
    }

    public static int binarySearch(ArrayList<String> strings, String string){
        int l = 0, r = strings.size() - 1;
        while (l<= r){
            int m = l + (r-l)/2;
            int res = string.compareToIgnoreCase(strings.get(m));

            if (res == 0){
                return m;
            }

            if (res > 0){
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }
        return -1;
    }
}
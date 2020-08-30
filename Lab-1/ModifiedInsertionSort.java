// Raymond Guevara Lozano 
// Brent Nishioka
// Scott Sakurai
// CECS 328-Sec09
import java.util.Arrays;
public class ModifiedInsertionSort {
    public static void main(String[] args) {
     String[] sortedList = insertionSort(args);
     System.out.println("Sorted Array: " + Arrays.toString(sortedList));
    }

    public static String[] insertionSort(String[] args){
        for (int j = 1; j < args.length; j++){ //begininng loop to get 2nd element of array
            String key = args[j];
            String stringj = key.substring(0, key.length() - 1); // comparing all characters except the last character of string
            int i = j - 1;
            int numberOfComparisons = 0;
            if ((args[i].substring(0, args[i].length() - 1).compareTo(stringj) <= 0)){ //count the instance in which element compares previous element
                numberOfComparisons++;                                                  // but does not go into loop
            }
            while (i >= 0 && ((args[i].substring(0, args[i].length() - 1).compareTo(stringj) > 0))){ //comparison of previous element(s)
                args[i + 1] = args[i];
                i = i -1;
                numberOfComparisons++;
                if ((i >= 0 && args[i].substring(0, args[i].length() - 1).compareTo(stringj) <= 0)){ //Compare the instance in which element compares previous element
                    numberOfComparisons++;                                                          // but does not return back into loop to count comparison
                }
            }
            System.out.println(key + " "  + numberOfComparisons);
            args[i+1] = key;
        }
        System.out.println();
        return args;
    }
}
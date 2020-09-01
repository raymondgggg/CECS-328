// Raymond Guevara Lozano 
// Brent Nishioka
// Scott Sakurai
// CECS 328-Sec09
public class ModifiedInsertionSort {
    public static void main(String[] args) {
        insertionSort(args);
   
    }

    public static void insertionSort(String[] args){
        String[] originalArgs = args.clone();
        int[] comparisons = new int[args.length];

        for (int j = 1; j < args.length; j++){ //begininng loop to get 2nd element of array
            String key = args[j];
            String stringj = key.substring(0, key.length() - 1); // comparing all characters except the last character of string
            int i = j - 1;
            int numberOfComparisons = 0;

            if ((args[i].substring(0, args[i].length() - 1).compareTo(stringj) <= 0)){ //count the instance in which element compares previous element
                numberOfComparisons++;                                                 // but does not go into loop to update the count
                comparisons[j] = numberOfComparisons;                                                 
            }

            while (i >= 0 && ((args[i].substring(0, args[i].length() - 1).compareTo(stringj) > 0))){ //comparison of previous element(s)
                args[i + 1] = args[i];
                i = i -1;
                numberOfComparisons++;
                comparisons[j] = numberOfComparisons;
                if ((i >= 0 && args[i].substring(0, args[i].length() - 1).compareTo(stringj) <= 0)){ //Compare the instance in which element compares previous element
                    numberOfComparisons++;                                                           // but does not return back into loop to update count comparison
                    comparisons[j] = numberOfComparisons;                                                     
                }
            }
            args[i+1] = key;
        }

        for (int i = 0; i < args.length; i++){ // printing sorted list 
            System.out.print(args[i] + " ");
        }

        System.out.println();

        for (int i = 1; i < originalArgs.length; i ++){ // printing the number of comparisons in the order of original input
            System.out.println(originalArgs[i] + " " + comparisons[i]);
        }
    }
}
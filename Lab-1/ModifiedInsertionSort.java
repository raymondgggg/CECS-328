// Raymond Guevara Lozano 
// Brent Nishioka
// Scott Sakurai
// CECS 328-Sec09
import java.util.Arrays;
public class ModifiedInsertionSort {
    public static void main(String[] args) {
        
        String s = "raymond";
        String r = "ramond";
        System.out.println(s.compareTo(r));
    

    }

    public static String[] insertionSort(String[] args){
        for (int j = 1; j < args.length; j++){
            String key = args[j];
            String stringj = args[j].substring(0, key.length() - 1);
            int i = j - 1;
            String stringi = args[i].substring(0, args[i].length() - 1);
            int numberOfComparisons = 0;
            while (i >= 0 && (stringi.compareTo(stringj) > 0)){
                args[i + 1] = args[i];
                i = i -1;
                numberOfComparisons++;
            }
            System.out.println(args[j] + " "  + numberOfComparisons);
            args[i+1] = key;
        }
        return args;
    }

}
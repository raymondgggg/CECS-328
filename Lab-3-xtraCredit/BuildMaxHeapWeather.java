import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BuildMaxHeapWeather {

    public static void main(String[] args) {
        int temp = (int) Math.floor(makeRequest(args[0]));
        int[] maxHeapArray = new int[temp];
        System.out.println(temp + " randomly generated integers:");
        for (int i = 0; i < temp; i++){
            int j = ThreadLocalRandom.current().nextInt(201);
            maxHeapArray[i] = j;
            System.out.print(j + " ");
        }
        System.out.println("\n\nMax Heap Array:");
        buildMaxHeap(maxHeapArray);
        printMaxHeap(maxHeapArray);
    }

    public static double makeRequest(String location) {
        String key = "5af53fae335b496725f258a89fff5286";
        String urlStr = "http://api.openweathermap.org/data/2.5/weather?appid=" + key + "&q=" + location
                + "&units=imperial";
        double temp = 0;
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            String jsonStr = result.toString();
            temp = getTemp(jsonStr);
          
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public static double getTemp(String jsonStr){
        double temp = 0;
        JSONParser p = new JSONParser();
        try {
            var data = p.parse(jsonStr);
            JSONObject jObject = (JSONObject) data;
            JSONObject mainData = (JSONObject) jObject.get("main");
            temp = (double) mainData.get("temp");
            return temp;
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Build max heap subroutine where the elements of array are inserted into the
     * heap
     * 
     * @param A the array
     * @param i the index
     */
    public static void maxHeapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < A.length && A[l] > A[i]) { // l < A.length because of indexing
            largest = l;
        } else {
            largest = i;
        }
        if (r < A.length && A[r] > A[largest]) { // r < A.length because of indexing
            largest = r;
        }
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest);
        }
    }

    /**
     * Method where the max heap is made
     *
     * @param A the array
     */
    public static void buildMaxHeap(int[] A) {
        for (int i = (int) Math.floor(A.length / 2); i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    /**
     * get the left child of index
     *
     * @param i index inputted
     * @return left child location index
     */
    public static int left(int i) {
        return 2 * i + 1; // add extra because of indexing
    }

    /**
     * Get the right child of index
     *
     * @param i index inputted
     * @return right child location index
     */
    public static int right(int i) {
        return 2 * i + 2;
    }

    /**
     * return the height of the heap
     *
     * @param aLen length of array
     * @return the height
     */
    public static int getHeight(int aLen) {
        return (int) Math.ceil((Math.log(aLen + 1) / Math.log(2)) - 1);
    }

    /**
     * Print the max heap
     * 
     * @param A the array representation of max heap
     */
    public static void printMaxHeap(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Height: " + getHeight(A.length));
    }
}
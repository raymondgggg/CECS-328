// Scott Sukari
// Brent Nishioka
// Raymond Guevara Lozano

/**Class where the max heap is made and all needed functions are implmented */
public class BuildMaxHeap{
    /**Main Method where all the methods of the program are used
     * @param args Command line argument of int array used to build max heap
     */
    public static void main(String[] args) {
        int[] A = new int[args.length];
        for (int i = 0; i < args.length; i++){
            A[i] = Integer.parseInt(args[i]);
        }
       
        buildMaxHeap(A);
        printMaxHeap(A);
    }

    /** Build max heap subroutine where the elements of array are inserted into the heap
     * @param A the array
     * @param i the index
     */
    public static void maxHeapify(int [] A, int i){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < A.length && A[l] > A[i]){ // l < A.length because of indexing 
            largest = l;
        }
        else{
            largest = i;
        }
        if (r < A.length && A[r] > A[largest]){ // r < A.length because of indexing
            largest = r;
        }
        if (largest != i){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest);
        }
    }

    /** Method where the max heap is made
     * @param A the array
     */
    public static void buildMaxHeap(int[] A){
        for (int i = (int) Math.floor(A.length/2); i >= 0; i--){
            maxHeapify(A, i);
        }
    }

    /**
     * get the left child of index
     * @param i index inputted
     * @return left child location index
     */
    public static int left(int i){
        return 2*i + 1; //add extra because of indexing 
    }

    /**
     * Get the right child of index
     * @param i index inputted
     * @return right child location index
     */
    public static int right(int i){
        return 2*i + 2;
    }

    /**
     * return the height of the heap
     * @param aLen length of array
     * @return the height
     */
    public static int getHeight(int aLen){
        return (int) Math.ceil((Math.log(aLen + 1) / Math.log(2)) - 1);
    }
    /**
     * Print the max heap 
     * @param A the array representation of max heap
     */
    public static void printMaxHeap(int [] A){
        for (int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Height: " + getHeight(A.length));
    }
}
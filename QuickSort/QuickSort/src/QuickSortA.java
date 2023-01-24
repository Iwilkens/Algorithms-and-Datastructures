import java.util.Random;

public class QuickSortA {

    /* 
    public static void main(String[] args) {

        int k = 10_000;
        int n = 10_000;
        long t_total = 0;
  
        //printA(testArray);
        for(int i = 0; i < k; i++){
            Random rand = new Random();
            int[] testArray = new int[n];
            for (int j = 0; j < testArray.length; j++){
                testArray[j] = rand.nextInt(300);
            }
            long t0 = System.nanoTime();
            quickSortA(testArray, 0, testArray.length-1);
            t_total += (System.nanoTime() - t0);
        }
        System.out.println(t_total/(double)k);
        
        //printA(testArray);
    }
    */

    public static void quickSortA(int[] array, int low, int high){

        if (low >= high){
            return;
        }
        // Tar random för att få en annan spridning än att ta första elementet
        // Leta upp källa för detta?
        int randomPivot = new Random().nextInt(high-low) + low;
        int pivot = array[randomPivot];
        swap(array, randomPivot, high);

        int lPointer = partition(array, low, high, pivot);

        quickSortA(array, low, lPointer -1);
        quickSortA(array, lPointer +1, high);
    }

    private static int partition(int[] array, int low, int high, int pivot) {
        int lPointer = low;
        int rPointer = high;

        while (lPointer < rPointer){
            while (array[lPointer] <= pivot && lPointer < rPointer){
                lPointer++;
            }
            while (array[rPointer] >= pivot && lPointer < rPointer){
                rPointer--;
            }
            swap(array, lPointer, rPointer);
        }

        if (array[lPointer] > array[high]){
            swap(array, lPointer, high);
        }
        else{
            lPointer = high;
        }
        return lPointer;
    }

    public static void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    public static void printA(int [] array){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}

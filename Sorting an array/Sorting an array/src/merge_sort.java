import java.util.Random;

public class merge_sort {

    public static void main(String[] args) {

        int k = 1000;
        int n = 100_000;
        long t_total = 0;

        for( int i = 0; i < k; i++){
            int[]array = unSorted(n);
            long t0 = System.nanoTime();
            mergeSort(array);
            t_total += (System.nanoTime() - t0);
        }
        System.out.println(t_total/(double)k);
 
    }

    private static void mergeSort(int[] array){

        if (array.length < 2 )
        return;


        int mid = array.length/2; 
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int index = 0; index < mid; index++){
            left[index] = array[index];
        }
        for (int index = mid; index < array.length; index++){
            right[index - mid] = array[index];
        }

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right){
        int leftLen = left.length;
        int rightLen = right.length;

        int indexLeft = 0, indexRight = 0, indexMerge = 0;

        while (indexLeft < leftLen && indexRight < rightLen){
            if (left[indexLeft] <= right[indexRight]){
                array[indexMerge] = left[indexLeft];
                indexLeft++;
            }
            else{
                array[indexMerge] = right[indexRight];
                indexRight++;
            }
            indexMerge++;
        }
        while (indexLeft < leftLen){
            array[indexMerge] = left[indexLeft];
            indexLeft++;
            indexMerge++;
        }
        while (indexRight < rightLen){
            array[indexMerge] = right[indexRight];
            indexRight++;
            indexMerge++;
        }
    }

    private static int[] unSorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] = rnd.nextInt(1000);
        }
        return array;
    }   
}

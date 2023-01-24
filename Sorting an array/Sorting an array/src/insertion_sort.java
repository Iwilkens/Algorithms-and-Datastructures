import java.util.Random;

public class insertion_sort {

    public static void main(String[] args) {
        int k = 1;
        int n = 100_000;
        long t_total = 0;


        for( int index = 0; index < k; index++){
            int[]array = unSorted(n);
            long t0 = System.nanoTime();
            for(int i = 1; i < array.length; i++){
                int cand = array[i];
                int j = i - 1;
                while( j>=0 && array[j] > cand){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = cand;
            }
            t_total += (System.nanoTime() - t0);    
        }
        System.out.println(t_total/(double)k);

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

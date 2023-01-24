import java.util.Random;
public class selection_sort {

    public static void main(String[] args) {
        int k = 1;
        int n = 100_000;
        long t_total = 0;
        


        
        for( int x = 0; x < k; x++){
            int[]array = unSorted(n);
            long t0 = System.nanoTime();
            for (int i = 0; i < array.length -1; i++){
                int cand = array[i];
                int temp;
                for (int j = i; j < array.length; j++){
                    if (array[j] < cand){
                        temp = array[j];
                        array[j] = cand;
                        cand = temp;
                    }
                array[i]= cand;
                }
            t_total += (System.nanoTime() - t0);
            }
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

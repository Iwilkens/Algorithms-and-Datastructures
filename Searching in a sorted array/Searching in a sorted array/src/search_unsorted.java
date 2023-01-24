import java.util.Random;

public class search_unsorted {

    public static void main(String[] args) {
        long t0 = System.nanoTime(); 
        long t_total = 0; 
        int k = 100;
        Random rnd = new Random();
        int[]array = sorted(1_000_000);

        for( int i = 0; i < k; i++){
            searchUnsorted(array, rnd.nextInt(10*array.length));
        }
        t_total = (System.nanoTime() - t0);
        System.out.println(t_total/(double)k);
    }

    public static boolean searchUnsorted(int[] array, int key) {
        //System.out.println("key: " + key);
        for (int index = 0; index < array.length ; index++) {
            //System.out.println(array[index]);
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] = rnd.nextInt(10);
        }
        return array;
    }    
}
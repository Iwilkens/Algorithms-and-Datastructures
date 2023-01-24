import java.util.Random;

public class search_sorted {

    public static void main(String[] args) {
        long t0 = System.nanoTime(); 
        long t_total = 0; 
        int k = 1_000_000;
        Random rnd = new Random();
        int[]array = sorted(100_000);

        for( int i = 0; i < k; i++){
            searchSorted(array, rnd.nextInt(10*array.length));
        }
        t_total = (System.nanoTime() - t0);
        System.out.println(t_total/(double)k);
    }

    public static boolean searchSorted(int[] array, int key) {
        //System.out.println("key: " + key);
        for (int index = 0; index < array.length ; index++) {
            //System.out.println(array[index]);
            if (array[index] > key) {
                return false; 
            }
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }    
}
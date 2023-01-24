import java.util.Random;

public class best {

    public static void main(String[] args) {
        long t_total = 0; 
        int k = 1_000_00;
        int n = 1_00_000;
        int[]keys = sorted(n);
        int[]array = sorted(n);
        
        long t0 = System.nanoTime(); 
        for( int i = 0; i < k; i++){
            search_best(array, keys);
        }   
        t_total = (System.nanoTime() - t0);
        System.out.println("tid: " + t_total/(double)k);
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

    public static int search_best(int[] array, int[] key) {
        int sum = 0;
        int ArrayIndex = 0;
        int KeyIndex = 0;

        while (ArrayIndex < array.length && KeyIndex < key.length ) {
            if (array[ArrayIndex] == key[KeyIndex]) {
                //System.out.println("Träff!");
                //System.out.println("array[ArrayIndex]: " + array[ArrayIndex]);
                //System.out.println("key[KeyIndex]: " + key[KeyIndex]);
                KeyIndex++;
                sum++;
                continue;
            }
            if (array[ArrayIndex] < key[KeyIndex]) {
                ArrayIndex++;
                continue;
            }
            if (array[ArrayIndex] > key[KeyIndex]) {
                KeyIndex++;
                continue;
            }
        }
        return sum; 
    }  
}
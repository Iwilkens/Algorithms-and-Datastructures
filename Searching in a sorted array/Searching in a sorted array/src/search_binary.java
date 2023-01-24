import java.util.Random;

public class search_binary {

    public static void main(String[] args) {
        long t0 = System.nanoTime(); 
        long t_total = 0; 
        int k = 1_000_000;
        Random rnd = new Random();
        int[]array = sorted(64_000_000);

        for( int i = 0; i < k; i++){
            binary_search(array, rnd.nextInt(10*array.length));
        }
        t_total = (System.nanoTime() - t0);
        System.out.println(t_total/(double)k);
    }

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;

        while (true) {
            // jump to the middle
            int index = first + ((last-first)/2);

            if (array[index] == key) {
                //System.out.println("Found");
                return true;
            }
            if (array[index] < key && index < last) {
            // The index position holds something that is less than
            // what we're looking for, what is the first possible page?
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
            // The index position holds something that is larger than
            // what we're looking for, what is the last possible page?
                last = index -1 ;
                continue;
            }
            // Why do we land here? What shoudl we do?
            break;
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

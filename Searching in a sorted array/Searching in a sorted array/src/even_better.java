import java.util.Random;

public class even_better {

    public static void main(String[] args) {
        long t_total = 0; 
        int k = 1_0_000;
        int n = 1_00_000;
        int[]keys = sorted(n);
        int[]array = sorted(n);
        int sum = 0; 
        long t0 = System.nanoTime(); 

        for( int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                //System.out.println("Varv: " + j);
                if (binary_search(array, keys[j])==true){
                    sum++;
                }
            }   
        }
        t_total = (System.nanoTime() - t0);
        System.out.println("tid: " + t_total/(double)k);
        System.out.println("snitt träffar: " + sum/(double)k);
        System.out.println("antal träffar: " + sum);
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
}
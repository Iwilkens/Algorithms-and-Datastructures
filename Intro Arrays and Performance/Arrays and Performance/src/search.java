import java.util.Random;

public class search{
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner (System.in);
        System.out.println ("Array size: ");
        int arraysize = in.nextInt();
        System.out.print(acess(arraysize));
    }

    public static double acess(int n) {
        int m = 100;
        int k = 1_000_000;
        int sum = 0;
        long t_total = 0;
        long t0 = 0; 
        int l = n;
        Random rnd = new Random();

        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {

            // fill the keys array with random number from 0 to 10*n
            for (int i = 0; i < m; i++){
                keys[i]= rnd.nextInt((n*10));
            }
    
            // fill the array with with random number from 0 to 10*n
            for (int i = 0; i < l; i++){
                array[i]= rnd.nextInt((n*10));
            }

            t0 = System.nanoTime();

            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n ; i++) {
                    if (array[i] == key){
                        sum++;
                        break;
                    }
                }
            }  
            t_total += (System.nanoTime() - t0); 
        }
        return t_total/(double)k; 
    }
}

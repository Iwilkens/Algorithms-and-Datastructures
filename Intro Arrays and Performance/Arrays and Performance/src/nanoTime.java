import java.util.Random;

public class nanoTime{
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner (System.in);
        System.out.println ("Array size: ");
        int arraysize = in.nextInt();
        System.out.print(acess(arraysize));
    }
    public static double acess(int n){

        int k = 1_000_000;
        int l = n;

        Random rnd = new Random();

        int[] indx = new int[l];
        // fill the indx array with random number from 0 to n (not including n)
        for (int i = 0; i < l; i++){
            indx[i] = rnd.nextInt(n);
        }

        int[] array = new int[n];
        // fill the array with dummy values (why not 1)
        for (int i = 0; i < n; i++){
            array[i]= 1;
        }

        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                // access the array with the index given by indx[i]
                // sum up the result
                sum += array[indx[i]];
                }
            }
            long t_access = (System.nanoTime() - t0);
            
            t0 = System.nanoTime();
            // do the same loop iteration but only do a dummy add operation
            for (int j = 0; j < k; j++){
                sum=sum+1;
            }
            long t_dummy = (System.nanoTime() - t0);
            return ((double)(t_access - t_dummy))/((double)k*(double)l);
    }
}
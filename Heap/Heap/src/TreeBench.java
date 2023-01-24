import java.util.Random;

public class TreeBench {
    public static void main(String[] args) {
        int k = 100;
        int n = 64;
        long t_total = 0;

                
        for(int i = 0; i < k; i++){
            TreeHeap test = new TreeHeap();
            Random rand = new Random();
            for (int j = 0; j < n; j++){
                test.add(rand.nextInt(100), rand.nextInt(100));
            }
            //System.out.println(test.push(rand.nextInt(20)));
            t_total += (test.push(rand.nextInt(20)));
        }
        System.out.println(t_total/(double)k);
        
        /* 
        System.out.println("----------------N Y  R U N----------------------");
        for (int i : test){
            System.out.println("priority " + i);
        }

        System.out.println(test.push(99));

                test.add(1, 55);
        test.add(7, 43);
        test.add(16, 32);
        test.add(6, 899);
        
        test.add(12, 61);
        test.add(19, 1);
        
        test.add(2, 512);
        test.add(72, 12);

    

        System.out.println("--------------------------------------");

        for (int i : test){
            System.out.println("priority " + i);
        }
        */
    
    }    
}

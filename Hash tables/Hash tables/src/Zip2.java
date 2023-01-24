import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Zip2 {
    public static void main(String[] args) throws Exception {

        Zip3 test = new Zip3("postnummer.csv");

        /* 
        // U T S K R I F T S    M E T O D 
        for (int i = 0; i < test.data.length; i++){
            System.out.println(test.data[i].code);
        }
        */
        
        //System.out.print(test.linearLookup("983 34"));
        //System.out.print(binary_search(test.data, "983 34"));
        //System.out.print(binary_search(test.data, "33"));

        //System.out.println(test.lookup(98499));

        /* 
        int k = 100_000;
        int n = 10;
        long t_total = 0;     
        for(int i = 0; i < k; i++){
            
            
            Random rand = new Random();
            String s = "";
            s += (String.valueOf(rand.nextInt(999)) + " ");
            s += String.valueOf(rand.nextInt(99));
            

            long t0 = System.nanoTime();
            test.lookup(98499);
            //binary_search(test.data, 98499);
            t_total += System.nanoTime() - t0;
        }
        System.out.println(t_total/(double)k);
        */
        test.collisionTest(10313);

    }

    Node[] data;
    Integer[] keys;
    Integer[] hashKeys;
    int max;

    public class Node{
        public Integer code;
        public String name;
        public Integer pop;

        public Node(Integer code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public Zip2(String file){
        int size = 9675;
        data = new Node[size];
        keys = new Integer[size];
        hashKeys = new Integer[size];
        int M = 1234;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));

                //System.out.println(code);
                keys[i] = code;
                hashKeys[i] = hash(code, M);
                data[hashKeys[i]] = new Node(code, row[1], Integer.valueOf(row[2]));
                i++;
            }
            max = i-1;
            } catch (Exception e) {
            System.out.println(" file " + file + " not found");
            }    
                /* 
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int j = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[j++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = j-1;
            } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
        */
    }

    public boolean linearLookup(Integer key){
        for (int i = 0; i < this.data.length; i++){
            if (this.data[i].code.equals(key)){
                return true;
            }
        }
        return false;
    }


        public boolean lookup(Integer key){
            if (this.data[key].code.equals(key)){
                return true;
            }
            else{
                return false;
            }
        }

        //testmetod som tar ett modulo
        public void collisionTest(int mod){
            int testData[] = new int[mod];
            int collisions[] = new int[10];

            for (int i = 0; i < max; i++){
                Integer index = keys[i] % mod;
                collisions[testData[index]]++;
                testData[index]++;
            }
            System.out.print(mod);
            for (int i = 0; i < 10; i++) {
                System.out.print("\t" + collisions[i]);
            }
            System.out.println();
        }

        public static int hash(Integer code, int mod){
            return code % mod;
        }
}
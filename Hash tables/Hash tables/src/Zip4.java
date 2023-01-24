import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Zip4 {
    public static void main(String[] args) throws Exception {

        Zip4 test = new Zip4("postnummer.csv");
        test.countStepsInLookup();

        /* 
        // U T S K R I F T S    M E T O D 
        for (int i = 0; i < test.data.length; i++){
            System.out.println(test.data[i].code);
        }
        */

            /* 
            Random rand = new Random();
            String s = "";
            s += (String.valueOf(rand.nextInt(999)) + " ");
            s += String.valueOf(rand.nextInt(99));
            */
        
        //System.out.print(test.linearLookup("983 34"));
        //System.out.print(binary_search(test.data, "983 34"));
        //System.out.print(binary_search(test.data, "33"));

        //System.out.println(test.lookup(98499));

    
        int k = 100_000;
        int n = 10;
        long t_total = 0;     
        for(int i = 0; i < k; i++){
            
        

            long t0 = System.nanoTime();
            test.lookup(98499);
            t_total += System.nanoTime() - t0;
        }
        System.out.println(t_total/(double)k);
    
    

    }

    Node[] data;
    Integer[] keys;
    Integer[] hashKeys;
    int max;
    int mod = 10000;

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

    public Zip4(String file){
        int size = 9675;
        data = new Node[mod];
        keys = new Integer[size];
        hashKeys = new Integer[size];
        

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                keys[i] = code;
                hashKeys[i] = hash(code, mod);
                i++;

                //System.out.println(code);
                insert(code, new Node(code, row[1], Integer.valueOf(row[2])));

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

    public String lookup(Integer code){
        Integer key = code % mod;
        while (!this.data[key].code.equals(code)){
            key++;
        }
        return this.data[key].name;
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

    public static int hash(Integer code, int M){
        return code % M;
    }

    // insert vi skickar koden och en ny nod med den nya koden 

    public void insert(Integer code, Node entry){
        // vi plockar fram får hashnyckel
        Integer key = code % mod;

        // om indexplatsen redan är tagen stegar vi istället framåt
        while (this.data[key] != null){
            key++;
        }
        this.data[key] = entry;
    }

    public void countStepsInLookup() {
        int steps = 0;
        int maximum = 0;
        double average = 0;
        double numberOfTimesWeNeedToStep = 0;
        for (int i = 0; i < this.keys.length; i++) {
            int code = this.keys[i];
            Integer key = code % this.mod;
            steps = 0;
            while (!this.data[key].code.equals(code)) {
                key++;
                steps++;
                average++;
            }
            if (steps > 0) {
                //System.out.println("for code " + code + ", steps = " + steps);
                numberOfTimesWeNeedToStep++;
            }
            if (steps > maximum) {
                maximum = steps;
            }
        }
        System.out.println("max steps was: " + maximum);
        System.out.println("average steps was " + average / numberOfTimesWeNeedToStep);
        System.out.println("average number of times we needed to step was " + average / this.keys.length);
        System.out.println("number of times we needed to step " + numberOfTimesWeNeedToStep);
    }
}
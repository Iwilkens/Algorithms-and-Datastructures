import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Zip3 {
    public static void main(String[] args) throws Exception {

        Zip3 test = new Zip3("postnummer.csv");

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
        public Node next;

        public Node(Integer code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
            this.next = null;
        }
    }

    public Zip3(String file){
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

                //System.out.println(code);
                insert(code, new Node(code, row[1], Integer.valueOf(row[2])));
                keys[i] = code;
                hashKeys[i] = hash(code, mod);
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
        Integer index = key % mod;
        Node curr = data[index];
        while (curr != null){
            if (key.equals(curr.code)){
                return true;
            }
            curr = curr.next;
        }
        return false;
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
        // vi plockar fram f??r hashnyckel
        Integer key = code % mod;

        Node curr = this.data[key];
        Node prv = null;
        
        // vi kollar om det redan ligger ett element p?? platsen
        // om de har samma modulotal byggs en l??nk i kedjan
        // P?? det s??ttet kan vi bygga p?? v??ran hink
        while (curr != null){
            if (code.equals(curr.code)){
                curr = curr.next;
                // detta kommer aldrig att h??nda f??r alla har olika postnummer
                break;
            }
            prv = curr;
            curr = curr.next;
        }

        // om d??r vi st??r ??r skiljt fr??n null l??gger vi in nya noden p?? n??sta
        if (prv != null){
            prv.next = entry;
        }
        // annars om d??r vi stod redan var null s?? l??gger vi in den d??r 
        else{
            data[key] = entry;
        }
        // Vi l??gger next pekaren till den efter d??r vi har lagt in. 
        entry.next = curr;
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Zip {
    public static void main(String[] args) throws Exception {

        Zip test = new Zip("postnummer.csv");

        /* 
        // U T S K R I F T S    M E T O D 
        for (int i = 0; i < test.data.length; i++){
            System.out.println(test.data[i].code);
        }
        */
        
        //System.out.print(test.linearLookup("983 34"));
        //System.out.print(binary_search(test.data, "983 34"));
        //System.out.print(binary_search(test.data, "33"));
        
        int k = 100_000;
        int n = 10;
        long t_total = 0;     
        for(int i = 0; i < k; i++){
            
            /* 
            Random rand = new Random();
            String s = "";
            s += (String.valueOf(rand.nextInt(999)) + " ");
            s += String.valueOf(rand.nextInt(99));
            */
            long t0 = System.nanoTime();
            binary_search(test.data, 11115);
            t_total += System.nanoTime() - t0;
        }
        System.out.println(t_total/(double)k);
    }

    Node [] data;
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

    public Zip(String file){
        data = new Node[9675];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
            } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean linearLookup(Integer key){
        for (int i = 0; i < this.data.length; i++){
            if (this.data[i].code.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static boolean binary_search(Zip.Node[] array, Integer key) {
        int first = 0;
        int last = array.length-1;

        while (true) {
            // jump to the middle
            int index = first + ((last-first)/2);

            if (array[index].code.equals(key)) {
                //System.out.println("Found");
                return true;
            }
            if (array[index].code.compareTo(key) < 0 && index < last) {
            // The index position holds something that is less than
            // what we're looking for, what is the first possible page?
                first = index + 1;
                continue;
            }
            if (array[index].code.compareTo(key) > 0  && index > first) {
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

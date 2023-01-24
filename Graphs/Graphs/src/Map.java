import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Map {
    private final int mod = 541;
    private City[] cities;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))){

            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (lookup(row[0]) == null) {
                    addCity(new City(row[0]));
                }
                if (lookup(row[1]) == null) {
                    addCity(new City(row[1]));
                }
                lookup(row[0]).addConnection(this.lookup(row[1]), Integer.valueOf(row[2]));
                lookup(row[1]).addConnection(this.lookup(row[0]), Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public static void main(String[] args) {
        Map map = new Map("hest.csv");
    }

    private void addCity(City city) throws Exception {
        int index = hash(city.name);

        while (index < cities.length) {
            if (cities[index] == null) {
                cities[index] = city;
                return;
            }
            index++;
        }
        throw new Exception("No empty index to insert new city");
    }

    private Integer hash(String name) {
        int hash = 7;

        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public City lookup(String city) {
        int index = hash(city);

        while (cities[index] != null) {
            if (cities[index].name.equals(city)) {
                return cities[index];
            }
            index++;
        }
        return null;
    }
}



/* 
public class Map {


    public static void main(String[] args) {
        Map test = new Map("hest.csv");

        /* 
        System.out.println(test.cities[test.keys[0]].name);
        System.out.println(test.cities[test.keys[0]].size);
        System.out.println(test.cities[test.keys[0]].neighbours.length);
        System.out.println(test.cities[test.keys[0]].neighbours[0].name);
        */

        /* 
        int x = 51;
        //int x = 3
        for (int i = 0; i < x; i++){
            int y = test.cities[test.keys[i]].size;
            for (int j = 0; j < y; j++){
                System.out.println(test.cities[test.keys[i]].name + " till " + test.cities[test.keys[i]].neighbours[j].destination.name + " tar "
                + test.cities[test.keys[i]].neighbours[j].distance + " minuter");
            }  
        } 
    }

    private City[] cities;
    private Integer keys[] = new Integer[75];
    int keyindex = 0;
    private final int mod = 541;


    public Map(String file){
        cities = new City[mod];
        /* 
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        */

        /* 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8)))
        {
            String line;
            while ((line = br.readLine()) != null){
                String[] row = line.split(",");
                String from = row[0];
                String to = row[1];
                Integer distance = Integer.valueOf(row[2]);
                addCity(new City(from), new City(to), distance);

                // Johans kod

                Han tar också fram och lookupar här i whole loopen
                Johans lookup skapar nya städer om de inte finns

                City one ... lookup row0


            } 
        }
        catch (Exception e){
            System.out.println("Mapping error.");
        }
    }

    private Integer hash(String name){
        int hash = 7;
        for(int i = 0; i < name.length(); i++){
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    /* 
    public String lookup(String name){
        Integer key = hash(name);
        //System.out.println("Nu kör vi lookup: " + lookupindex+1);
        lookupindex++;
        System.out.println("Hej6");
        if (this.cities[key]== null){
            System.out.println("Hej7");
            return null;
        }
        System.out.println("Hej8");
        while (!this.cities[key].name.equals(name)){
            System.out.println("Hej9");
            key++;
            System.out.println("Hej10");
        }
        System.out.println("Hej11");
        return this.cities[key].name;
    }
    */
    /* 
    public City lookup(String namn){
        int index = hash(namn);
        while (cities[index] != null){
            if (cities[index].name.equals(namn)){
                return cities[index];
            }
            index++;
        }
        return null;
    }

    public void addCity(City from, City to, Integer distance){
        Integer fromKey = hash(from.name);
        Integer toKey = hash(to.name);

        if (lookup(from.name) == null){
            insert(from.name);
        }
        if (lookup(to.name) == null){
            insert(to.name);
        }
        this.cities[fromKey].addConnection(to, distance);
        this.cities[toKey].addConnection(from, distance);
    }

    // tanken här inserta from to ch distance in i cities arrayen på ett 
    public void insert(String name){
        // vi plockar fram får hashnyckel
        Integer key = hash(name);

        // om indexplatsen redan är tagen stegar vi istället framåt
        while (this.cities[key] != null){
            key++;
            }
        this.cities[key] = new City(name);

        // koden nedan kanske inte behöver vara med i rapporten utan används främst i testsyfte
        keys[keyindex] = key;
        //System.out.println("Lagt till " + this.cities[key].name + " på plats " + key + " antal tillagda: " + (keyindex + 1));
        //System.out.println("__________________________________________________________________");
        keyindex++;
    }   
}

*/
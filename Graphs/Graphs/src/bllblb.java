public class bllblb {
    /* 
    public static void main (String[] args) {
        final int NS_IN_MS = 1_000_000;
        long t0, time;
        String from = args[0];
        String to = args[1];
        int max = Integer.valueOf(args[2]);

        Map map = new Map("trains.csv");

        t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        time = (System.nanoTime() - t0) / NS_IN_MS;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }

    private static Integer shortest (City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;
        Integer dist, totalDist;
        for (int i = 0; i < from.connections.length; i++) {
            if (from.connections[i] != null) {
                Connection conn = from.connections[i];
                dist = shortest(conn.destination, to, max - conn.distance);
                
                if (dist != null) {
                    totalDist = dist + conn.distance;
                    if (shrt == null || totalDist < shrt)
                        shrt = totalDist;
                }
            }
        }

        return shrt;
    }
    */
/* 
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
                    try {
                        addCity(new City(row[0]));
                    }
                    catch (Exception e){
                        System.out.println(e.getLocalizedMessage());
                    }
                }
                if (lookup(row[1]) == null) {
                    try {
                        addCity(new City(row[1]));
                    }
                    catch (Exception  e){
                        System.out.println(e.getLocalizedMessage());
                    }
                }
                lookup(row[0]).addConnection(this.lookup(row[1]), Integer.valueOf(row[2]));
                lookup(row[1]).addConnection(this.lookup(row[0]), Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public static void main(String[] args) {
        Map map = new Map("./trains.csv");
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
        throw new Exception("Couldn't find empty index to insert new city");
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
}
*/
}
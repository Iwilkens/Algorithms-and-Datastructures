public class Naive {
    public static void main(String[] args) {

        String from = ("Göteborg");
        String to = ("Umeå");
        Integer max = 800;

        Map map = new Map("hest.csv");

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }

    

    private static Integer shortest(City from, City to, Integer max){
        if (max < 0){
            return null;
        }
        if (from == to){
            return 0;
        }
        Integer shrt = null;
        Integer traversed;
        Integer traversedTot;
        for (int i = 0; i < from.neighbours.length; i++){
            if (from.neighbours[i] != null){
                Connection conn = from.neighbours[i];
                //System.out.println(from.neighbours[i].destination.name);
                
                traversed = shortest(conn.destination, to, max - conn.distance);
                
                if (traversed != null){
                    traversedTot = traversed + conn.distance;
                    if (shrt == null || traversedTot < shrt){
                        shrt = traversedTot;
                    }
                }
            }
        }
        return shrt;
    }


    // lägga till hans implementation med max?


    /* 
    private static Integer shortest (City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;
        Integer dist, totalDist;
        for (int i = 0; i < from.neighbours.length; i++) {
            if (from.neighbours[i] != null) {
                Connection conn = from.neighbours[i];
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
}
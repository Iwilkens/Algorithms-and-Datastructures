public class Paths {


    City [] path;
    int sp;

    public Paths(){
        path = new City[54];
        sp = 0;
    }

    private Integer shortest(City from, City to, Integer max){
        if (max < 0){
            return null;
        }
        if (from == to){
            return 0;
        }
        Integer shrt = null;

        for (int i = 0; i < sp; i++){
            if (path[i] == from){
                return null;
            }
        }

        Integer traversed;
        Integer traversedTot;

        path[sp++] = from;

        for( int i = 0; i < from.neighbours.length; i++){
            if (from.neighbours[i] != null){
                Connection conn = from.neighbours[i];
                traversed = shortest(conn.destination, to, max - conn.distance);
                
                if (traversed != null){
                    traversedTot = traversed + conn.distance;
                    if (shrt == null || traversedTot < shrt){
                        shrt = traversedTot;
                    }
                }
            }
        }
        path[sp--] = null;
        return shrt;
    }

    public static void main(String[] args) {

        String from = ("Malmö");
        String to = ("Kiruna");
        Integer max = 10000;

        Map map = new Map("hest.csv");
        Paths path = new Paths();

        long t0 = System.nanoTime();
        Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}



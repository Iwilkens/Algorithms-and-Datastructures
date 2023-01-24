public class City {

    /*
    public static void main(String[] args) {
        City test = new City("Peking");
        test.addConnection("Stockholm", 200);
        test.addConnection("Hässleholm", 120);

        for (int i = 0; i < test.size; i++){
            System.out.println(test.name + " till " + test.neighbours[i].name + " tar " + test.neighbours[i].distance + " minuter.");
        }
        
    }

    */
    public String name;
    public Connection[] neighbours;
    public int size = 0;

    public City(String name){
        this.name = name;
        this.neighbours = new Connection[75];
    }

    /* 

    public void addConnection(City destinationCity, Integer distance){
        int i = 0;
        while (neighbours[i] != null){
            i++;
       }
       neighbours[i] = new Connection(destinationCity, distance);
    }
    */

    
    public void addConnection(City name, int distance){
        Connection newC = new Connection(name, distance);
        neighbours[size] = newC;
        size++;
    }

}

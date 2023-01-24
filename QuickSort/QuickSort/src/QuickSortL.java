import java.util.Random;

public class QuickSortL {

    public static void main(String[] args) {
        int k = 10_00;
        int n = 10_000;
        long t_total = 0;

        for(int i = 0; i < k; i++){
            Random rand = new Random();
            QuickSortL testList = new QuickSortL();
            for(int j = 0; j < n; j++){
                testList. add(rand.nextInt(300));
            }
            Node node = testList.head;
            while (node.tail != null){
                node = node.tail;
            }
            long t0 = System.nanoTime();
            // Kör funktionen
            testList.quickSortL(testList.head, node);
            t_total += (System.nanoTime() - t0);  
        }
        System.out.println(t_total/(double)k);
    }
    /* 
    public static void main(String[] args) {

        int k = 10_000;
        int n = 10_000;
        long t_total = 0;
  
        //printA(testArray);
        for(int i = 0; i < k; i++){
            Random rand = new Random();
            int[] testArray = new int[n];
            for (int j = 0; j < testArray.length; j++){
                testArray[j] = rand.nextInt(300);
            }
            long t0 = System.nanoTime();
            quickSortA(testArray, 0, testArray.length-1);
            t_total += (System.nanoTime() - t0);
        }
        System.out.println(t_total/(double)k);
        
        //printA(testArray);
    }
    */

    public static class Node{
        int item;
        Node tail;

        Node (int item){
            this.item = item;
            this.tail = null;
        }
    }

    Node head;
    //lägger till ett element på slutet av den länkade listan
    //genom att leta upp var sista är som har sin tail till null
    //Och istället sätta dit en nod med vår data. 
    void add(int item){
        if (head == null){
            head = new Node(item);
            return;
        }

        Node curr = head;
        while (curr.tail != null){
            curr = curr.tail;
        }

        Node temp = new Node (item);
        curr.tail = temp;
    }    

    public void printL(Node node){
        while (node != null){
            System.out.print(node.item);
            System.out.print(" ");
            node = node.tail;
        }

    }

    // Partition
    // Koden tar den första och den sista noden utan
    // att bryta några länkar i listan

    public Node partition(Node first, Node last){
        if (first == null || last == null || first==last){
            return first; 
        }

        Node recursive_pivot = first; 
        Node curr = first;
        int pivot = last.item; 

        //Kör koden fram tills en innan slutet
        //Eftersom pivot kommer vara sista behöver vi 
        //Inte köra hela vägen till slutet. 
        //både current och rec pivot är pekare som vi flyttar
        //i int pivot håller vi koll på värden.

        //koden flyttar allt som är mindre än sista elementet pivot till
        //vänstra sidan av den länkade listan, vi har kvar pekarna
        //men byter plats på värdena
        while (first != last){
            if (first.item < pivot){

                //kollar vilken nod vi ändrade senast
                recursive_pivot = curr;
                int temp = curr.item;
                curr.item = first.item;
                first.item = temp;
                curr = curr.tail;
            }
            first = first.tail;
        }

        //När den länkade listan är uppdelad efter större och mindre
        //Sätter vi elementet som delar störra och mindre som den nya
        //Pivot punkten.
        int temp = curr.item;
        curr.item = pivot;
        last.item = temp;

        // Vi skickar tillbaks pekare till noden som är ett steg
        // innan pivot
        return recursive_pivot;
    }

    public void quickSortL(Node first, Node last){
        if (first == null || first == last.tail || first==last){
            return;
        }

        //Dela upp listan och kör partition operationen
        Node recursive_pivot = partition(first, last);
        quickSortL(first, recursive_pivot);

        //Om vår pivot och first pekaren pekar på samma element
        //Tar vi elementet efter som vår nya pivot
        if (recursive_pivot != null && recursive_pivot == first){
            quickSortL(recursive_pivot.tail, last);
        }

        //Om vår pivot hamnar melland listorna 
        //Börjar vi istället på den som är efter
        //eftersom att det vi har tillgång till är den innan 
        // hoppar vi fram två steg.
        else if (recursive_pivot != null && recursive_pivot.tail != null){
            quickSortL(recursive_pivot.tail.tail, last);
        }

    }
}

import java.util.Random;

public class LinkedPriority2 {
    public static void main(String[] args) {
        
        
        /* 
        test.add(4, 2);
        test.add(200, 1);
        test.add(5, 4);
        test.add(6, 5);
        test.add(7, 0);
        test.printL(test);

        test.remove();
        test.printL(test);

    
        test.remove();
        test.printL(test);

        test.remove();
        test.printL(test);
        */
        long t_total = 0;
        long t0;
        int n = 10;
        int loop = 1000;
        Random rnd = new Random();
        for (int i = 0; i < loop; i++) {
            LinkedPriority2 test = new LinkedPriority2();
            for (int j = 0; j < n; j++){
                test.add(rnd.nextInt(300), rnd.nextInt(300));
            }
            t0 = System.nanoTime();
            test.add(rnd.nextInt(300), rnd.nextInt(300));
            test.remove();
            t_total += System.nanoTime() - t0;
        }
        System.out.println(t_total/loop);
    }





    Node head;

    public class Node{
        public int item;
        public int priority;
        public Node tail;

        public Node(int item, int priority, Node list){
            this.item = item;
            this.priority = priority;
            this.tail = list;
        }
    }

    public LinkedPriority2(){
        this.head = null;
    }

    public Node remove(){
        Node next = head;
        Node smallest = head;
        Node previous = null;

        while(next.tail != null){
            if (next.tail.priority < smallest.priority){
                smallest = next.tail;
                previous = next;
            }
            next = next.tail;
        }

        if(smallest != head){
            previous.tail = smallest.tail;
        }
        else{
            head = head.tail;
        }
        
        return smallest; 
    }


    public void add(int item, int priority){

        Node new_node = new Node(item, priority, null);
        if (head == null){
            head = new_node;
        }
        else{
            new_node.tail = head;
            head = new_node;
        } 
    }

    public void printL(LinkedPriority2 list){

        Node next = list.head;
        System.out.print("LinkedList: ");
        while (next != null){
            System.out.print(next.item + " ");
            next = next.tail;
        }
    }
}
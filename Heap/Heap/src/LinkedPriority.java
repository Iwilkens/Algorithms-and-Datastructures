import java.util.Random;

public class LinkedPriority {

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
        */
        int n = 100_000;
        int loop = 1000;
        long t_total = 0;
        long t0;
        Random rnd = new Random();
        LinkedPriority test = new LinkedPriority();
        for (int j = 0; j < n; j++){
            test.add(rnd.nextInt(300), rnd.nextInt(300));
        }
        
        
        for (int i = 0; i < loop; i++) {
            

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

    public LinkedPriority(){
        this.head = null;
    }

    public Node add(int item, int priority){

        LinkedPriority.Node next = head;

        Node new_node = new Node(item, priority, null);
        if (head == null){
            head = new_node;
        }

        //om huvudet på listan har mindre prio än den vi lägger till
        else if (head.priority > priority){
            new_node.tail = head;
            head = new_node;
        }

        else{
            while(next.tail != null && next.tail.priority < priority){
                next = next.tail;
            }
            new_node.tail = next.tail;
            next.tail = new_node;
        }
        return head;
    }

    public Node remove(){
        Node temp = this.head;
        head = this.head.tail;
        return temp; 
    }

    public void printL(LinkedPriority list){

        Node next = list.head;
        System.out.print("LinkedList: ");

        while (next != null){
            System.out.print(next.item + " ");
            next = next.tail;
        }
    }
}

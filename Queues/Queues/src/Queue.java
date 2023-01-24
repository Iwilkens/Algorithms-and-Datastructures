public class Queue {

    Node head;

    public class Node {

        public Integer item;
        public Node tail;

        public Node (Integer item, Node list){
            this.item = item;
            this.tail = list;
        }
    }

    public Queue(){
        this.head = null;
    }

    public void add(Integer item){

        Queue.Node next = head;
        Node new_node = new Node(item, null);
        if (head == null){
            head = new_node;
        }

        else{
            while(next.tail != null){
                next = next.tail;
            }
            next.tail = new_node;
        }
    }


    public Integer remove(){
        Integer temp = this.head.item;
        head = this.head.tail;
        return temp; 
    }


    public void print(Queue queue){

        Node next = queue.head;
        System.out.print("LinkedList: ");

        while (next != null){
            System.out.print(next.item + " ");
            next = next.tail;
        }
    }
    
}

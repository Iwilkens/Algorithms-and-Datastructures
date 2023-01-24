public class Queue2 {

    Node head;
    Node last; 

    public class Node {

        public Integer item;
        public Node tail;

        public Node (Integer item, Node list){
            this.item = item;
            this.tail = list;
        }
    }

    public Queue2(){
        this.head = null;
        this.last = null; 
    }

    public void add(Integer item){
        Node new_node = new Node(item, null);
        if (head == null){
            head = new_node;
            last = new_node; 
        }
        
        if (head == last){
            last = new_node;
            head.tail = last;
        }
        else{
            Queue2.Node temp = last; 
            last = new_node; 
            temp.tail = last; 
        }
    }


    public Integer remove(){
        Integer temp = this.head.item;
        head = this.head.tail;
        return temp; 
    }


    public void print(Queue2 queue){

        Node next = queue.head;
        System.out.print("LinkedList: ");

        while (next != null){
            System.out.print(next.item + " ");
            next = next.tail;
        }
    }
    
}
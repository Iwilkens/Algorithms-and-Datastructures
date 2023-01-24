public class Queue {

    Node head;
    Node last; 

    public class Node {

        public TreeHeap.Node item;
        public Node tail;

        public Node (TreeHeap.Node item, Node list){
            this.item = item;
            this.tail = list;
        }
    }

    public Queue(){
        this.head = null;
        this.last = null; 
    }

    public void add(TreeHeap.Node item){
        Node new_node = new Node(item, null);
        if (head == null){
            head = new_node;
            last = new_node; 
        }
        
        else if (head == last){
            last = new_node;
            head.tail = last;
        }
        else{
            Queue.Node temp = last; 
            last = new_node; 
            temp.tail = last; 
        }
    }


    public TreeHeap.Node remove(){
        TreeHeap.Node temp = this.head.item;
        head = this.head.tail;
        return temp; 
    }


    public void print(Queue queue){

        Node next = queue.head;
        System.out.print("LinkedList: ");

        while (next != null){
            System.out.print(next.item.priority + " ");
            next = next.tail;
        }
    }
}
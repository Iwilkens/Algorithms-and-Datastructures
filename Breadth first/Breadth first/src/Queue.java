public class Queue {

    Node head;
    Node last; 

    public class Node {

        public BinaryTree.Node item;
        public Node tail;

        public Node (BinaryTree.Node item, Node list){
            this.item = item;
            this.tail = list;
        }
    }

    public Queue(){
        this.head = null;
        this.last = null; 
    }

    public void add(BinaryTree.Node item){
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


    public BinaryTree.Node remove(){
        BinaryTree.Node temp = this.head.item;
        head = this.head.tail;
        return temp; 
    }


    public void print(Queue queue){

        Node next = queue.head;
        System.out.print("LinkedList: ");

        while (next != null){
            System.out.print(next.item.key + " ");
            next = next.tail;
        }
    }
    
}
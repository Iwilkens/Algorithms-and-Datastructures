public class Stack {
    LinkedList element = null;

    public void push(TreeHeap.Node node){
        element = new LinkedList(node, element);
    }

    public TreeHeap.Node pop(){
        TreeHeap.Node temp = this.element.head();
        element = this.element.tail();
        return temp;
    }

    public boolean isEmpty(){
        if (element == null){
            return true;
        }
        else{
            return false;
        }
    }
}
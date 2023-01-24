public class Stack {
    LinkedList element = null;

    public void push(BinaryTree.Node node){
        element = new LinkedList(node, element);
    }

    public BinaryTree.Node pop(){
        BinaryTree.Node temp = this.element.head();
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
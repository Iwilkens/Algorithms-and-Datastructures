public class Stack {
    LinkedList element = null;

    public void push(int item){
        element = new LinkedList(item, element);
    }

    public int pop(){
        int temp = this.element.head();
        element = this.element.tail();
        return temp;
    }
}
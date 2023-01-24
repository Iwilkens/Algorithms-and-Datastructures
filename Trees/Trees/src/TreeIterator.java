import java.util.Iterator;
import java.util.NoSuchElementException;


public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private Stack stack;

    public TreeIterator(BinaryTree.Node root){
        stack = new Stack();
        goLeft(root);
    }

    private void goLeft(BinaryTree.Node cur){
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    @Override
    public boolean hasNext(){
        return !stack.isEmpty();
    }

    @Override
    public Integer next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        BinaryTree.Node cur = stack.pop();

        if (cur.right != null){
            goLeft(cur.right);
        }
        return cur.key;
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
import java.util.Iterator;
import java.util.NoSuchElementException;


public class TreeIterator implements Iterator<Integer> {
    private TreeHeap.Node next;
    private Queue queue;

    public TreeIterator(TreeHeap.Node root){
        next = root;
        queue = new Queue();
        queue.add(root);
    }

    @Override
    public boolean hasNext(){
        return queue.head != null;
    }

    @Override
    public Integer next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }

        next = queue.remove();
        if(next.left() != null){
            queue.add(next.left);
        }
        if(next.right() != null){
            queue.add(next.right);
        }
        return next.priority;
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
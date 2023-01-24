import java.util.Iterator;
public class BinaryTree implements Iterable<Integer>{
    
    public class Node{
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public Integer key(){
            return this.key;
        }

        public Integer value(){
            return this.key;
        }
    
        public Node left(){
            return this.left;
        }

        public Node right(){
            return this.right;
        }

        private void add(Integer key, Integer value){
            if (this.key == key){
                this.value = value;
                return;
            }
            if (this.key > key){
                if(this.left != null){
                    this.left.add(key, value);
                }
                else{
                    this.left = new Node(key,value);
                }
            }
            else{
                if(this.right != null){
                    this.right.add(key, value);
                }
                else{
                    this.right = new Node(key,value);
                }
            }
        }

        public void print(){
            if(left != null){
                left.print();
                System.out.print("\t");
            }
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null){
                right.print();
                System.out.print("\t");
            }
        }
    }

    public Node root;

    public BinaryTree() {
        root = null;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }        

    public void add(Integer key, Integer value){
        if (root == null){
            root = new Node(key, value);
        }
        else{
            root.add(key, value);
        }
    }

    public Integer lookup(Integer key){
        Node cur = this.root;
        while (cur != null){
            if(cur.key == key){
                return cur.value;
            }
            if(cur.key < key){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        return null;
    }
}
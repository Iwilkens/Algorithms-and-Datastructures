import java.util.Iterator;
public class TreeHeap implements Iterable<Integer>{
    
    public class Node{
        public Integer priority;
        public Integer value;
        public Integer size;
        public Node left, right;

        public Node(Integer key, Integer value, Integer size){
            this.priority = key;
            this.value = value;
            this.size = size; 
            this.left = this.right = null;
        }

        public Integer key(){
            return this.priority;
        }

        public Integer value(){
            return this.priority;
        }
    
        public Node left(){
            return this.left;
        }

        public Node right(){
            return this.right;
        }

        // lägger till en nod kollar först om this har lika prio
        private void add(Integer priority, Integer value){
            if (this.priority == priority){
                this.value = value;
                return;
            }

            //om en framför i trädet har lägre prio så swappar vi värdena
            //och tar vidare ner i trädet
            if (priority < this.priority){
                int tempValue = this.value;
                int tempPrio = this.priority;
                this.value = value;
                this.priority = priority;
                value = tempValue;
                priority = tempPrio;
            }

            //när en nod rör sig ner i trädet ska dess size öka
            this.size++;

            // Vi lägger till en ny om det är null, är det inte
            // null går vi vidare ner rekursivt i trädet
            if (this.left == null){
                this.left = new Node(priority, value, 1);
            }
            else if (this.right == null){
                this.right = new Node(priority, value, 1);
            }
            else if (this.left.size < this.right.size){
                this.left.add(priority, value);
            }
            else{
                this.right.add(priority, value);
            }
        }

        //Remove 
        public Node remove(){

            // först kollar vi om de är null isf lägger swappar vi värdena
            // bara på rooten och sätter den efter till null
            if (this.left == null){
                    this.priority = this.right.priority;
                    this.value = this.right.value;
                    this.right = null;
                    this.size--;
                    return this;
                }

            if(this.right ==null){
                this.priority = this.left.priority;
                this.value = this.left.value;
                this.left = null;
                this.size--;
                return this;
            }

            // Här kollar vi om det inte är null och tittar istället på de 
            // efter. Om de har storlek ett vet vi att de inte har några 
            // barn och kan använda samma nullmetod som ovan. I annat fall
            // går vi vidare rekursivt tills vi hittar en men storlek 1.
            if (this.right.priority < this.left.priority){
                this.priority = this.right.priority;
                this.value = this.right.value;
                this.size--;
                if ( this.right.size == 1){
                    this.right = null;
                }
                else{
                    this.right = this.right.remove();
                }
                return this;
            }
            else{
                this.priority = this.left.priority;
                this.value = this.left.value;
                this.size--;
                if (this.left.size == 1){
                    this.left = null;
                }
                else{
                    this.left = this.left.remove();
                }
                return this;
            }
        }

        public void print(){
            if(left != null){
                left.print();
                System.out.print("\t");
            }
            System.out.println(" priority: " + priority + "\tvalue: " + value);
            if(right != null){
                right.print();
                System.out.print("\t");
            }
        }
    }


       

    public Node root;

    public TreeHeap() {
        root = null;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }        

    // add för heap som nyttjar add från den nästlade nodklassen
    public void add(Integer priority, Integer value){
        if (root == null){
            root = new Node(priority, value, 1);
        }
        else{
            root.add(priority, value);
        }
    }



    
    public void remove() throws NullPointerException{
        if(root == null){
            throw new NullPointerException("Heap is empty");
        }
        else if (root.right == null && root.left == null){
            root = null;
        }
        else{
            root.remove();
        }
    }

    public void swap(Node down, Node up){
        Integer tempPrio = down.priority;
        Integer tempValue = down.value;
        down.priority = up.priority;
        down.value = up.value;
        up.priority = tempPrio;
        up.value = tempValue;
    }

    public Integer push(Integer incr){
        this.root.priority += incr;
        Node curr = this.root;
        return push(this.root.priority, curr, (Integer)0);
    }

    private Integer push(Integer rootValue, Node curr, Integer depth){
        // om den nya prioriteten är mindre än det under ska den nya noden
        // stanna vid roten
        if (curr.left == null){
            if (rootValue < curr.right.priority){
                return depth;
            }
            //Om noden till höger har högre prio ska den upp så vi swappar
            //Och ökar djupet
            else if(curr.right.priority < rootValue){
                depth++;
                swap(curr, curr.right);
            }
            // om det finns fler än 1 under kallar vi på push rekursivt
            // för att fortsätta neråt i trädet.
            if (curr.right.size != 1){
                depth = push(rootValue, curr.right, depth);
            }
        } 
        if (curr.right == null){
            if (rootValue < curr.left.priority){
                return depth;
            }
            else if(curr.left.priority < rootValue){
                depth++;
                swap(curr, curr.left);
            }
            if(curr.left.size != 1){
                depth = push(rootValue, curr.left, depth);
            }
        }

        // här kollar i vilken håll vi ska gå åt om ingen av dem
        // är null. Då måste vi jämföra. På samma sätt om den vi har som 
        // root har lägst prio så går vi inte längre ner
        if (curr.right != null && curr.left.priority > curr.right.priority){
            if(curr.right.priority > rootValue){
                return depth;
            }
            else if(curr.right.priority < rootValue){
                depth++;
                swap(curr, curr.right);
            }
            if (curr.right.size != 1){
                depth = push(rootValue, curr.right, depth);
            }
        }
        else{
            if (curr.left.priority > rootValue){
                return depth;
            }
            else if(curr.left.priority < rootValue){
                depth++;
                swap(curr, curr.left);
            }
            if (curr.left.size != 1){
                depth = push(rootValue, curr.left, depth);
            }
        }
        return depth;
    }


    public Integer lookup(Integer priority){
        Node cur = this.root;
        while (cur != null){
            if(cur.priority == priority){
                return cur.value;
            }
            if(cur.priority < priority){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        return null;
    }

    
}
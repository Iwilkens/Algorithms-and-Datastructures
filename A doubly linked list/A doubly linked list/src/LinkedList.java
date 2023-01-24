public class LinkedList{
    int item;
    LinkedList tail;
    LinkedList head;
    public LinkedList(int item,  LinkedList taillist, LinkedList headlist){
        this.item = item;
        this.tail = taillist;
        this.head = headlist;
    }

    public LinkedList head(){
        return this.head;
    }

    public int item(){
        return this.item;
    }

    public LinkedList tail(){
        return this.tail;
    }

    public void append(LinkedList b){
        LinkedList nxt = this;
        while (nxt.tail != null){
            nxt = nxt.tail;
        }
        nxt.tail = b;
        b.head = nxt;
    }

    public LinkedList add(LinkedList linklist){
        LinkedList first = this;
        first.head = linklist;
        linklist.tail = first;
        return first.head;
    }

    public LinkedList remove(LinkedList linklist){
        LinkedList first = this;
        LinkedList nxt = linklist;
        if(nxt == first){
            nxt.tail.head = null;
            return nxt.tail;
        }
        else if (nxt.tail != null){
            nxt.head.tail = nxt.tail;
            nxt.tail.head = nxt.head;
            return first;
        }
        else{
            nxt.head.tail = null;
            return first;
        }
    }
    
    public void print(LinkedList b){
        LinkedList nxt = this;
        int i = 1;
        while (nxt.tail != null){
            //System.out.println("Element " + i + ": " + nxt.item);
            i++;
            nxt = nxt.tail;
        }
        //System.out.println("Element " + i + ": " + nxt.item);
    }
}


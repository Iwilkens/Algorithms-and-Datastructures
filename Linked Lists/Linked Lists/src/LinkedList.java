public class LinkedList {
    int head;
    LinkedList tail;
    public LinkedList(int item, LinkedList list){
        this.head = item;
        this.tail = list;
    }

    public int head(){
        return this.head;
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
    }
    
    public void print(LinkedList b){
        LinkedList nxt = this;
        int i = 1;
        while (nxt.tail != null){
            System.out.println("Element " + i + ": " + nxt.head);
            i++;
            nxt = nxt.tail;
        }
        System.out.println("Element " + i + ": " + nxt.head);
    }
    

    public LinkedList remove(LinkedList linklist){
        int itemKey = linklist.head;
        LinkedList first = this; 
        LinkedList nxt = first;
        if(nxt.head == itemKey){
            return nxt.tail;
        }
        while(nxt.tail != null && nxt.tail.head != itemKey){
            nxt=nxt.tail;
        }
        nxt.tail = nxt.tail.tail;
        return first;
    }

    public LinkedList add(LinkedList linklist){
        LinkedList first = this;
        linklist.tail = first;
        return linklist;
    }
}
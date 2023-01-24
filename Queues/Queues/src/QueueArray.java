public class QueueArray {
    Integer first = 0; 
    Integer last = 0;
    Integer size = 5;
    Integer queue[];

    public QueueArray(){
        queue = new Integer[size];
    }

    public void Enqueue(int data){
        /* 
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("Last är: " + last + " Size-1 är: " + (size-1));
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        */
        if (queue[0] == null && last == (size)){
            last = 0;
        }
        queue[last] = data; 
        last++;
    }

    public void Dequeue(){
        if (first == last){
            System.out.println("\nQueue is full\n");
            return;
        }
        if(first != (size-1)){
            queue[first] = null;
            first++;
        }
        else{
            queue[first] = null;
            first = 0;
        }
    }

    public boolean empty(){
        return (first == last);
    }

    public void printQueue(){
        for(int i = 0; i < size; i++){
            System.out.println(queue[i]);
        }
    }
}
public class DQueueArray {
    Integer first = 0; 
    Integer last = 0;
    Integer size = 5;
    Integer queue[];

    public DQueueArray(){
        queue = new Integer[size];
    }

    public void Enqueue(int data){
        /* 
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("Last är: " + last + " Size-1 är: " + (size-1));
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        */
        if (queue[0] == null && last == size){
            last = 0;
        }
        if (queue[0] != null && last == size){
            System.out.println("Dubbel addera");
            fullDouble();
        }
        queue[last] = data; 
        last++;
        if (first == last){
            wrapDouble(); 
        }
    }

    public void Dequeue(){
        if (first == last){
            System.out.println("Tom lista");
            return;
        }
        if(first != (size-1)){
            queue[first] = null;
            first++;
            if (first == last){
                wrapDouble(); 
            }
        }
        else{
            queue[first] = null;
            first = 0;
        }
    }

    public void printQueue(){
        for(int i = 0; i < size; i++){
            System.out.println(queue[i]);
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
    }

    public void wrapDouble(){
        size = size*2;
        Integer[] temp = new Integer[size];
        int a = 0;
        for(int i = first; i < queue.length; i++){
            temp[a] = queue[i];
            a++; 
        }
        for(int j = 0; j < (last-1); j++){
            temp[a] = queue[j];
            a++; 
        }
        first = 0;
        last = a;
        queue = temp;
    }

    public void fullDouble(){
        size = size*2;
        Integer[] temp = new Integer[size];
        int a = 0;
        for(int i = 0; i < queue.length; i++){
            temp[a] = queue[i];
            a++; 
        }
        first = 0;
        last = a;
        queue = temp;
    }
}
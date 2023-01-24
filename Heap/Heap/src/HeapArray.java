public class HeapArray {

    public static void main(String[] args) {
         // Display message
         System.out.println("The Min Heap is ");
 
         // Creating object opf class in main() methodn
         HeapArray minHeap = new HeapArray(15);
  
         // Inserting element to minHeap
         // using insert() method
  
         // Custom input entries
         minHeap.add(5);
         minHeap.add(3);
         minHeap.add(17);
         minHeap.add(10);
         minHeap.add(84);
         minHeap.add(19);
         minHeap.add(6);
         minHeap.add(22);
         minHeap.add(9);
  
         // Print all elements of the heap
         minHeap.printArray();
  
         // Removing minimum value from above heap
         // and printing it
         System.out.println("The Min val is "
                            + minHeap.remove());
        
    }

    public int[] heap;
    public int size;
    public int maximal_size;
    public int first = 0;


    //konstruktor för klassen
    public HeapArray(int maximal_size){
        this.maximal_size = maximal_size;
        this.size = 0;

        heap = new int[this.maximal_size];
        //heap[0] = 0;
    }

    // skickar tillbaks parent
    public int parent(int curr){
        return (curr / 2);
    }

    // skickar tillbaks left child för den nod vi har currently
    public int leftChild(int curr){
        return (curr *2);
    }

    // skickar tillbaks right child för den nod vi har currently
    public int rightChild(int curr){
        return ((curr * 2 ) + 1);
    }

    // kollar om det är ett blad
    public boolean isNull(int curr){
        if(curr > (size /2)){
            return true;
        }
        else{
            return false;
        }
    }

    // metod för att byta plats på två noder på heapen
    public void swap(int pos1, int pos2){
        int temp;
        temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    // metod för att se till att arrayen håller sig balanserad
    public void balance(int curr){
        if(isNull(curr) == false){

            int temp = curr;
        
            //kollar om barnen är null, om de inte är det behöver vi byta plats för
            //att balansera heapen.
            // första är ett corner case för absolut sista värdet
            if(rightChild(curr) <= size){
                if (heap[leftChild(curr)] < heap[rightChild(curr)]){
                    temp = leftChild(curr);
                }
                else if (heap[leftChild(curr)] > heap[rightChild(curr)]){
                    temp = rightChild(curr);
                }
                else{
                    temp = heap[leftChild(curr)];
                }
            }
            if (heap[curr] > heap[leftChild(curr)] || heap[curr] < heap[rightChild(curr)]){
                swap(curr, temp);
                balance(temp);
            }
        }
    }

    // ta bort elementet längst fram i kön och retunera det
    // tar sista elementet för att kunna sätta det längst fram
    // i arrayen och sedan låta det sjunka genom listan för att
    // få den korrekt ordnad som en heap via balance funktionen
    public int remove(){
        int toRemove = heap[first];
        heap[first] = heap[size--];
        balance(first);
        return toRemove;
    }

    public void printArray(){
        for(int i = 0; i <= size /2; i++){
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + heap[i]
                + " LEFT CHILD : " + heap[2 * i]
                + " RIGHT CHILD :" + heap[2 * i + 1]);
 
            // By here new line is required
            System.out.println();
        }
    }

    // bubble add där vi lägger till en nod och sedan 
    // bubblar tillbaks tills vi är på rätt ställe
    public void add(int newItem){
        if (size > maximal_size){
            throw new IndexOutOfBoundsException();
        }

        heap[++size] = newItem;
        int curr = size;

        while (heap[curr] < heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    
    
}
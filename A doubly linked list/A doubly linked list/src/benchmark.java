import java.util.Random;

public class benchmark {
    public static void main(String[] args) {

        int n = 10_000;
        int k = 2; 
        long t_total = 0;

        int[] numbersR = randArray(k);
        LinkedList a = createList(numbersR);
        LinkedList[]aList = indexArray(k, a);
        a.print(a);

        for(int i = 0; i < n; i++){
            Random rnd = new Random();
            int currentN = rnd.nextInt(k-1);
            //System.out.println("Siffran som leks med är: " + aList[currentN].item);
            long t0 = System.nanoTime();
            a = a.remove(aList[currentN]);
            a = a.add(aList[currentN]);
            t_total += (System.nanoTime() - t0);
            a.print(a);
            //System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        }
        System.out.println(t_total/(double)n);

        
/*
        a = a.add(10);

        a.print(a);

        a = a.remove(10);

        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");

        a.print(a);
        */
  
        /* 
        int k = 100;
        int n =100_000;
        long t_total = 0; 
        long t_total2= 0;

        for( int i = 0; i < k; i++){
            LinkedList a = createList(10);

            long t0 = System.nanoTime();
            LinkedList b = createList(n);
            t_total += (System.nanoTime() - t0);

            int[] arrayA = createArray(10);

            long t1 = System.nanoTime();
            int[] arrayB = createArray(n);
            t_total2 += (System.nanoTime() - t1);
            //b.append(a);
            //appendArray(arrayA, arrayB);
        }
        System.out.println("Tid för linked list: " + t_total/(double)k);
        System.out.println("Tid för array: " + t_total2/(double)k);
        */
        
        /*
        a.print(a);
        System.out.println("- - - - - - - - - - - - - - - - -");
        b.print(b);

        System.out.println("- - - - - - - - - - - - - - - - -");
        */
    }

    public static int[] randArray(int nElements) {
        Random rnd = new Random();
        int[]temp = new int[nElements];
        for(int i = 0; i < nElements; i++){
            temp[i] = rnd.nextInt(300);
            //System.out.println("Värde " + i + ": " + temp[i]);
        }
        return temp;
    }

    public static LinkedList[] indexArray(int length, LinkedList linkList) {
        LinkedList[] temp = new LinkedList[length]; 
        LinkedList nxt = linkList;
        int i = 0;
        while (nxt.tail != null){
            temp[i] = nxt;
            nxt = nxt.tail;
            i++;
        }
        return temp;
    }

    public static LinkedList createList(int[] randArray) {
        int nElements = randArray.length;
        //System.out.println("nElements är : " + nElements);
        LinkedList temp = new LinkedList(randArray[0], null, null);
        for(int i = 1; i < nElements; i++){
            temp.append(new LinkedList( randArray[i], null, null));
            //System.out.println("varv: " + i);
        }
        return temp;
    }
}
import java.util.Iterator;
import java.util.Random;

public class TreeBenchmark {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        for (int i : tree){
            System.out.println("next value " + i);
        }
        
        /* 
        int n = 100_000;
        int k = 100;
        long t_total = 0;

        for(int i = 0; i < k; i++){
            Random rnd = new Random();
            BinaryTree tree = createTree(n);
            long t0 = System.nanoTime();
            tree.lookup(rnd.nextInt(100));
            t_total += (System.nanoTime() - t0);
        }
        System.out.println(t_total/(double)k);


        /* 
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
        */
    }

    public static BinaryTree createTree(int size) {
        Random rnd = new Random();
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < size; i++){
            //tree.add(rnd.nextInt(100), rnd.nextInt(300));
            tree.add((i), rnd.nextInt(300));
        }
        return tree;
    }
}
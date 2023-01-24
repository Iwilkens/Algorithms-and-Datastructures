public class Benchmark {
    public static void main(String[] args) {

        DQueueArray kö = new DQueueArray();
        kö.Enqueue(1);
        kö.Enqueue(2);
        kö.Enqueue(3);
        kö.Enqueue(4);
        kö.Enqueue(5);
        kö.printQueue();
        kö.Enqueue(6);
        kö.printQueue();
        kö.Dequeue();
        kö.printQueue();
        kö.Dequeue();
        kö.printQueue();

        
        kö.Enqueue(7);
        kö.Enqueue(8);
        kö.Enqueue(9);
        kö.Enqueue(10);
        kö.Enqueue(11);
        kö.printQueue();

        kö.Enqueue(12);
        kö.Enqueue(13);
        kö.printQueue();

        kö.Enqueue(14);
        kö.Enqueue(15);
        kö.printQueue();
  



        /* 
        Queue2 test = new Queue2();
        test.add(12);
        test.add(10);
        test.add(17);
        test.add(19);
        test.add(22);
        test.print(test);
        test.remove();
        test.print(test);
        */
    }   
}

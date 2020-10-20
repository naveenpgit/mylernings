package threads;

import java.util.LinkedList;

/*
 * Producer puts 'n' elements to que, consumers wait until que is full. One of the consumer flushes the queue and waits until producer fills it up again.
 */
public class ProduceConsumer {

    public static final int CAPACITY = 5;

    public static void main(String[] args) throws Exception {

        LinkedList<Integer> myQueue = new LinkedList<>();

        Thread producer = new Thread(new Producer(myQueue));
        producer.start();

        Thread consumer = new Thread(new Consumer(myQueue, "C1"));
        consumer.start();

        Thread consumer_ = new Thread(new Consumer(myQueue, "C2"));
        consumer_.start();
    }

}

package threads;

import java.util.LinkedList;

import static threads.ProduceConsumer.CAPACITY;

public class Producer implements Runnable {

    private LinkedList<Integer> myQueue;

    public Producer(LinkedList<Integer> myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (myQueue) {
                try {
                    while (myQueue.size() == CAPACITY) {
                        myQueue.notifyAll(); //awakes all threads but does not release lock, awakned threads wait until lock being released
                        myQueue.wait(); // releases locks so other threads can begin run
                    }

                    System.out.println("Producing ::: " + i);
                    myQueue.add(i++);
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package threads;

import java.util.LinkedList;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

public class Consumer implements Runnable {
    private LinkedList<Integer> myQueue;

    private String name;

    public Consumer(LinkedList<Integer> myQueue, String name) {
        this.myQueue = myQueue;
        this.name = name;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (myQueue) {
                try {

                    while (isEmpty(myQueue)) {
                        myQueue.notifyAll();
                        myQueue.wait();

                    }

                    System.out.println("Consuming by " + name + " :::: " + myQueue.removeFirst());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

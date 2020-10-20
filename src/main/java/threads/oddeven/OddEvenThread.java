package threads.oddeven;

public class OddEvenThread implements Runnable {

    ThreadTest.LockObject lock;

    public OddEvenThread(ThreadTest.LockObject lock) {
        this.lock = lock;
    }

    int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (lock.lock) {
                try {
                    System.out.println(lock.i);
                    lock.lock.notifyAll();
                    lock.lock.wait();
                    Thread.sleep(1000);
                    lock.i += 2;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

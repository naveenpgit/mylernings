package threads.oddeven;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread oddThread = new Thread(new OddEvenThread(new LockObject(lock, false, 1)));
        Thread evenThread = new Thread(new OddEvenThread(new LockObject(lock, true, 2)));

        oddThread.start();

        evenThread.start();

    }

    static class LockObject {
        boolean isEven;

        Object lock;

        int i;

        public LockObject(Object lock, boolean isEven, int i) {
            this.lock = lock;
            this.isEven = isEven;
            this.i = i;
        }
    }
}

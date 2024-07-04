package threads.oddeven;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        Lock lock = new Lock(false);

        Thread oddThread = new Thread(new OddEvenThread(new ThreadMeta(lock, false, 1)));
        Thread evenThread = new Thread(new OddEvenThread(new ThreadMeta(lock, true, 2)));

        oddThread.start();
        evenThread.start();

    }

    @Data
    static class ThreadMeta {
        Lock lock;

        boolean isEven;

        public ThreadMeta(Lock lock, boolean isEven, int i) {
            this.lock = lock;
            this.isEven = isEven;
            this.i = i;
        }

        public Lock getLock() {
            return lock;
        }

        public void setLock(Lock lock) {
            this.lock = lock;
        }

        public boolean isEven() {
            return isEven;
        }

        public void setEven(boolean even) {
            isEven = even;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        int i;
    }

    @Data
    static class Lock {
        public Lock(boolean started) {
            this.started = started;
        }

        public boolean isStarted() {
            return started;
        }

        public void setStarted(boolean started) {
            this.started = started;
        }

        boolean started;
    }
}

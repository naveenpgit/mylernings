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
    @AllArgsConstructor
    static class ThreadMeta {
        Lock lock;

        boolean isEven;

        int i;
    }

    @Data
    @AllArgsConstructor
    static class Lock {
        boolean started;
    }
}

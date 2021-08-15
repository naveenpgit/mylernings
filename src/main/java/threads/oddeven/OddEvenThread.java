package threads.oddeven;

import threads.oddeven.ThreadTest.ThreadMeta;

public class OddEvenThread implements Runnable {

    ThreadMeta threadMeta;

    public OddEvenThread(ThreadMeta threadMeta) {
        this.threadMeta = threadMeta;
    }

    int i = 1;

    @Override
    public void run() {
        while (true) {
            if (threadMeta.isEven && !threadMeta.lock.isStarted()) {
                return;
            }
            synchronized (threadMeta.lock) {
                try {
                    threadMeta.lock.setStarted(true);
                    System.out.println(threadMeta.i);
                    threadMeta.lock.notifyAll();
                    threadMeta.lock.wait();
                    Thread.sleep(1000);
                    threadMeta.i += 2;
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

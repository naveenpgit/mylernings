package threads;

import java.util.ArrayList;
import java.util.Iterator;

public class StringWordsAltThread {
    static Iterator<String> iterator;

    public static void main(String[] args) throws InterruptedException {

        StringWordsAltThread stringWordsAltThread = new StringWordsAltThread();
        stringWordsAltThread.blah();

    }

    void blah() throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");

        iterator = list.iterator();

        MyThread myThread = new MyThread("");
        Thread t1 = new Thread(new MyThread("t1"));
        Thread t2 = new Thread(new MyThread("t2"));
        Thread t3 = new Thread(new MyThread("t3"));

        t1.start();
        t2.start();
        t3.start();
    }

    class MyThread implements Runnable {

        String name;

        public MyThread(String name) {
            this.name = name;
        }

        public void run() {
            while (true) {
                synchronized (StringWordsAltThread.iterator) {
                    if (StringWordsAltThread.iterator.hasNext()) {
                        System.out.println(name + " :::: " + StringWordsAltThread.iterator.next());
                        StringWordsAltThread.iterator.remove();
                        try {
                            StringWordsAltThread.iterator.notifyAll();
                            StringWordsAltThread.iterator.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                }
            }

        }
    }
}


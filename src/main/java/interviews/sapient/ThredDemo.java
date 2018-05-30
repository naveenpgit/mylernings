package interviews.sapient;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class ThredDemo {
    public static void main(String[] args) {

        List<Integer> ts = new ArrayList<>();
        ts.add(100);
        ts.add(1);
        ts.add(1000);
        ts.add(10);
        ts.add(10000);
        ts.add(10);

        NavigableSet<Integer> n = new TreeSet<>(ts);
        System.out.println(n.tailSet(10, false));
        System.out.println(n.tailSet(10));
        System.out.println(n.higher(10));
        int a = n.pollFirst();
        System.out.println(n.size());

    }
}
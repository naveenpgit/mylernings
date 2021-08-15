package interviews.sapient;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(4);
        list.add(5);

        System.out.println(Collections.binarySearch(list, 4));
    }
}

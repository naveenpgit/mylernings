package learn;

import java.util.ArrayList;

public class JTest {
    public static void main(String[] args) {
//        TreeSet ts = new TreeSet();
//
//        ts.add(13.1);
//        ts.add(1);
//        ts.add(13.1);
//        ts.add(12.6);
//
//        for (int i = 0; i < ts.size(); i++) {
//            System.out.println(ts.pollFirst());
//        }
//------//------//------//------//------//------

//        TreeMap treeMap = new TreeMap();
//        treeMap.put("vv", 1);
//        treeMap.put("ww", 2);
//        treeMap.put("xx", 3);
//        treeMap.put("yy", 4);
//
//        NavigableMap navigableMap = treeMap.headMap("xx", false);
//        System.out.println(navigableMap);

        //------//------//------//------//------

        ArrayList<Integer> LST = new ArrayList<>();
        populateNu(LST);
        int sum = 0;
        for (Integer integer : LST) {
            sum = sum + integer;
        }
        System.out.println(sum);
    }

    static void populateNu(ArrayList<Integer> LST) {
        LST.add(new Integer(1));
        LST.add(new Integer(2));
    }
}


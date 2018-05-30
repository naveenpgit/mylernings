package interviews.tavant;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem2 {

    static class Blah {

        public String name = "firstName";
    }

    static class Add {


        Map<String, Integer> hashMap = new HashMap<>();

        Map<String, Integer> treeMap = new TreeMap<>();

        public void updateMap(String name) {

            Problem2 problem2 = new Problem2();
            hashMap.put("blah", 1);
            hashMap.put(name, 1);

            treeMap.put("blah", 1);
            treeMap.put(name, 1);
        }
    }


    public static void main(String[] args) {
        String a = new String("naveen"),
                b = new String("goudar");

        Blah blah = new Blah();
        System.out.println(blah.name);
        updateBlah(blah);
        System.out.println(blah.name);

        System.out.println("updateValues ::: " + updateValues(a, b));
        System.out.println("Concatenated Name :: " + a.concat(b));
        System.out.println("A :: " + a + "   and B ::: " + b);

        Add addd1 = new Add();
        addd1.updateMap("kumar");

        Add add2 = addd1;
        add2.updateMap("anotherName");

        System.out.println("hashMap content is ::: " + addd1.hashMap.toString());
        System.out.println(" treeMap content is ::: " + addd1.treeMap.toString());

    }

    private static String updateValues(String a, String b) {
        a = a.concat(b);
        b = " updated Name";

        return a.concat(b);
    }

    static void updateBlah(Blah blah) {
        blah = new Blah();
        blah.name = "blah name updated";
    }
}



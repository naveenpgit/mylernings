package java8;

import java.util.HashMap;
import java.util.Map;

public class MapIterator {

    public static void main(String[] args) throws Exception {
        Map<String, String> defaultPam = new HashMap<>();

        defaultPam.put("1", "One");
        defaultPam.put("2", "two");
        defaultPam.put("3", "three");

        Map<String, String> uiresponse = new HashMap<>();

        defaultPam.forEach(
                (k, v) -> {
                    if (k.equals("designation")) {
                        uiresponse.put("Role-----",
                                "PAM");
                    } else {
                        uiresponse.put(k, v);
                    }
                });

    }

}

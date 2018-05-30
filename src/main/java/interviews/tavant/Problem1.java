package interviews.tavant;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("\\\\'", "\\\'");
        String name = "O\\'Brian";
        for (Map.Entry<String, String> entry : myMap.entrySet()) {
            name.replace(entry.getKey(), entry.getValue());
        }

        System.out.println(name);
    }

}

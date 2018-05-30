package algorithm.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViralAdvertising {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(viralAdvertising(34));
    }

    static int viralAdvertising(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(2);

        if (n > list.size()) {

            int current = 1;

            while (current < n) {
                list.add(list.get(current - 1) * 3 / 2);
                current++;
            }
        }

        return list.stream().limit(n).reduce((x, y) -> x + y).orElse(0);

    }
}

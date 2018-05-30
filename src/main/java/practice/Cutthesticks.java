package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cutthesticks {
    static int[] cutTheSticks(int[] arr) {

        List<Integer> res = new ArrayList<>();

        List<Integer> current = Arrays.stream(arr).boxed().collect(Collectors.toList());

        while (!current.isEmpty()) {
            res.add(current.size());
            List temp = new ArrayList();
            final int min = current.stream().mapToInt(v -> v).min().orElse(0);

            current.stream().forEach(x -> {
                if (x - min != 0) {
                    temp.add(x - min);
                }
            });

            current = temp;
        }

        return res.stream().mapToInt(Integer::new).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int[] result = cutTheSticks(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}

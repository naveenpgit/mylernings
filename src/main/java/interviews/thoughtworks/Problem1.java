package interviews.thoughtworks;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t > 0) {

            int total = scanner.nextInt();
            int speed = scanner.nextInt();

            int[] files = new int[total];
            for (int i = 0; i < total; i++) {
                files[i] = scanner.nextInt();
            }

            Arrays.sort(files);
            //System.out.println(calcuate(files, speed, 0));
            System.out.println(improved(files, speed));
            t--;
        }

    }

    private static int calcuate(int[] files, int speed, int sum) {

        int unfinished = files.length;

        if (unfinished == 0) {
            return sum;
        } else {
            double fileSpeed = Math.ceil(speed / unfinished);
            int firstOne = files[0];
            sum += Math.ceil(firstOne / fileSpeed);
            files = Arrays.stream(files).map(x -> x - firstOne).filter(x -> x != 0).toArray();
            return calcuate(files, speed, sum);
        }
    }

    private static int improved(int[] files, int speed) {
        int done = 0,
                sum = 0,
                i = 0,
                j = i + 1;

        while (j < files.length) {

            int current = files[i];
            if (current != 0) {
                sum += Math.ceil(current / Math.ceil(speed / (files.length - i)));
                done += current;
            }
            files[j] -= done;
            i++;
            j++;
        }

        sum += Math.ceil(files[i] / Math.ceil(speed / (files.length - i)));

        return sum;
    }
}

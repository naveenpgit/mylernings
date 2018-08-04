package algorithm.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DesignerPDFViewer {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {

        List<String> alps = Arrays.stream("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")).collect(Collectors.toList());

        int max = Arrays.stream(word.toUpperCase().split("")).map(x->{
            return h[alps.indexOf(x)];
        }).max(Integer::compareTo).orElse(0);

        return word.length() * max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        System.out.println(result);

        scanner.close();
    }
}

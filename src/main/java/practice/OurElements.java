package practice;

import java.util.Scanner;

public class OurElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();
        for (int i = 0; i < numberOfInputs; i++) {
            int n = scanner.nextInt();
            int[] inArray = new int[n];
            for (int j = 0; j < n; j++) {
                inArray[j] = scanner.nextInt();
            }
            int X = scanner.nextInt();
            System.out.println(fourElements(inArray, n, X));
        }


    }

    private static int fourElements(int[] inArray, int n, int x) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (inArray[i] + inArray[j] + inArray[k] + inArray[l] == x) {
                            System.out.println(inArray[i] + ":::" + inArray[j] + ":::" + inArray[k] + ":::" + inArray[l]);
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }
}

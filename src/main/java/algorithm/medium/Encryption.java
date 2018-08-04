package algorithm.medium;

import java.io.IOException;
import java.util.Scanner;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        int column = (int) Math.sqrt(s.length()) + 1;

        String[] temp = new String[column];

        for (int i = 0; i < column; i++) {
            int index = i;
            StringBuffer stringBuffer = new StringBuffer();
            while (index < s.length()) {
                stringBuffer.append(s.charAt(index));
                index+=column;
            }
            temp[i] =(stringBuffer.toString());
        }
        return String.join(" " , temp);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = encryption(s);

        System.out.println(result);
        scanner.close();
    }
}

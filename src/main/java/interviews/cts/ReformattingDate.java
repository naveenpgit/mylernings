package interviews.cts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReformattingDate {

    static String[] reformatDate(String[] dates) {

        List<String> res = new ArrayList<>();
        List<String> months =
                Arrays.asList("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec");

        for (String date : dates) {
            String[] parts = date.split(" ");

            String year = parts[2];
            int month = months.indexOf(parts[1].toLowerCase()) + 1;
            int day = Integer.parseInt(
                    parts[0].indexOf("th") != -1 ? parts[0].substring(0, parts[0].indexOf("th")) :
                            parts[0].indexOf("st") != -1 ? parts[0].substring(0, parts[0].indexOf("st")) :
                                    parts[0].indexOf("nd") != -1 ? parts[0].substring(0, parts[0].indexOf("nd")) :
                                            parts[0].indexOf("rd") != -1 ? parts[0].substring(0, parts[0].indexOf("rd")) : ""
            );


            String join = String.join("-", year, (month < 10 ? "0" : "") + String.valueOf(month), (day < 10 ? "0" : "") + String.valueOf(day));
            System.out.println(join);
            res.add(join);
        }

        return res.toArray(new String[0]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int datesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] dates = new String[datesCount];

        for (int i = 0; i < datesCount; i++) {
            String datesItem = scanner.nextLine();
            dates[i] = datesItem;
        }

        String[] res = reformatDate(dates);


        scanner.close();
    }
}

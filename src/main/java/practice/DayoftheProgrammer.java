package practice;

public class DayoftheProgrammer {
    // Complete the solve function below.
    static String solve(int year) {

        boolean isJulian = year <= 1917;

        //return (year % 4 == 0 ? "12" : "13") + ".09." + String.valueOf(year);

        int date = 13;
        if (year == 1918) {
            date += date;
        } else if ((isJulian && year % 4 == 0) || (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            date = 12;
        }

        return String.valueOf(date) + ".09." + String.valueOf(year);
    }

    public static void main(String[] args) {
        System.out.println(solve(2017));//13.09.2017
        System.out.println(solve(2016));//12.09.2016
        System.out.println(solve(1800));//12.09.1800
        System.out.println(solve(1918));//23.09.1800
        System.out.println(solve(2000));//12.09.1800
    }
}

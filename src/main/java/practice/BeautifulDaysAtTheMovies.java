package practice;

public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) {
        System.out.println(beautifulDays(20, 23, 6));
    }

    static int beautifulDays(int i, int j, int k) {

        int count = 0;
        for (; i <= j; i++) {
            if (Math.abs(i - reverse(i)) % k == 0) {
                count++;
            }
        }

        return count;
    }

    static int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse = reverse * 10;
            reverse = reverse + n % 10;
            n = n / 10;
        }

        return reverse;
    }
}

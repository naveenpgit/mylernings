package bigdecimal;

import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("123");
        BigDecimal bigDecimal_ = new BigDecimal("123.00");
        System.out.println(bigDecimal.equals(bigDecimal_));
        System.out.println(bigDecimal.compareTo(bigDecimal_));
    }
}

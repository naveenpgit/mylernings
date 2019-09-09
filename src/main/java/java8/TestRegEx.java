package java8;

import java.util.Arrays;

public class TestRegEx {
    public static void main(String[] args) {
        String[] in = new String[]{
                "loan/urlas/{0}/borrowers/{0}/employer/{0}/monthlyIncome",
                "loan/urlas/{0}/borrowers/{0}/employer/{0}/overtime",
                "loan/urlas/{0}/borrowers/{0}/employer/{0}/bonus",
                "loan/urlas/{0}/borrowers/{0}/employer/{0}/commission",
                "loan/urlas/{0}/borrowers/{0}/employer/{0}/other"
        };
        String regEx = "loan/urlas/\\{\\d}/borrowers/\\{\\d\\}/employer/\\{\\d\\}/(monthlyIncome|overtime|bonus|commission|other)";

        Arrays.stream(in).forEach(x -> System.out.println(x.matches(regEx)));
    }
}

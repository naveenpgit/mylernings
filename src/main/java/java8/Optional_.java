package java8;

import java.util.Optional;

public class Optional_ {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("A").orElse(getDefaultValue()));
        System.out.println(Optional.ofNullable("A").orElseGet(() -> getDefaultValue()));
        System.out.println(Optional.ofNullable(null).orElseGet(() -> getDefaultValue()));
    }

    static String getDefaultValue() {
        System.out.println("hey there!!!");
        return "B";
    }
}

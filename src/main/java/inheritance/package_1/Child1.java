package inheritance.package_1;

public class Child1 implements Parent {
    @Override
    public String fetchMessage() {

        if (true) {
            throw new RuntimeException("Sorry I can not fetch");
        }

        return "Hello from Child ::::: A";
    }
}

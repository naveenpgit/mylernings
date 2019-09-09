package inheritance.package_1;

public class ParentChildTest {
    public static void main(String[] args) {
        try {
            Parent p = new Child1();
            System.out.println(p.fetchMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

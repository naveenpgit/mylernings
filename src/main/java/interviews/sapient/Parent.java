package interviews.sapient;

public class Parent {
    int a = 10;

    Parent(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        Parent ac = (Parent) obj;
        return (a ^ ac.a) != 0;
    }
}

class Test_ {
    public static void main(String[] args) {
        Parent parent = new Parent(10);
        Parent parent_ = new Parent(10);
        System.out.println(parent.equals(parent_));
    }

}


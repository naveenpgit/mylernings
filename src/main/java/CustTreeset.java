import lombok.Data;

import java.util.TreeSet;

public class CustTreeset {
    static TreeSet<Employee> treeSet = new TreeSet<>();

    public static void main(String[] args) {


        treeSet.add(new Employee("c"));
        treeSet.add(new Employee("d"));
        treeSet.add(new Employee("a"));
        treeSet.add(new Employee("c"));

        for (Employee s : treeSet) {
            System.out.println(s.name);
        }
    }

}

@Data
class Employee implements Comparable {

    String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object obj) {
        int res = (((Employee) obj).name.compareTo(this.name));

        return res == 0 ? res : 100;
    }
}

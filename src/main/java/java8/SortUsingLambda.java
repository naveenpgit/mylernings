package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortUsingLambda {

    private static class Developer {
        String name;
        int salary;
        int age;

        public Developer(String name, int salary, int age) {
            this.name = name;
            this.salary = salary;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Developer{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    '}';
        }
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<>();

        result.add(new Developer("mkyong", 70000, 33));
        result.add(new Developer("alvin", 80000, 20));
        result.add(new Developer("jason", 100000, 10));
        result.add(new Developer("iris", 170000, 55));

        return result;

    }

    public static void main(String[] args) {
        SortUsingLambda sortUsingLambda = new SortUsingLambda();

        List<Developer> developers = getDevelopers();
        System.out.println("Before sorting........");
        sortUsingLambda.printMe(developers);

        System.out.println("Sorted by age........");
        developers.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
        sortUsingLambda.printMe(developers);

        System.out.println("Sorted by salary........");
        Comparator<Developer> developerComparator = (Developer o1, Developer o2) -> o1.getSalary() - o2.getSalary();
        developers.sort(developerComparator.reversed());
        sortUsingLambda.printMe(developers);
    }

    void printMe(List<Developer> developers) {
        developers.forEach(System.out::println);
    }
}

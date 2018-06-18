package interviews.cts;

import java.util.Scanner;

public class LetsMakeAClone {
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            Human h1 = new Human(in.next());
            Human h2 = (Human) h1.clone();

            in.close();

            if (h1 == h2) {
                System.out.println("You did not clone the object.");
            } else {
                System.out.println("Created a human called: " + h1.name);
                System.out.println("Created a clone called: " + h2.name);
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Human implements Cloneable {

     String name;

    public Human(String next) {
        this.name = next;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Human(this.name);
    }
}

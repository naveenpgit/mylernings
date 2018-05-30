package cts;


public class TestThread {
    public static void main(String[] args) {
        FoodFactory myFoods = new FoodFactory();
        Food food1 = myFoods.getFood("FastFood");
        Food food2 = myFoods.getFood("Fruit");
        System.out.println("My name is: " + food1.getClass().getName());
        System.out.println("My name is: " + food2.getClass().getName());
        System.out.println("Our superclass is: "
                + food1.getClass().getSuperclass().getName());
        food1.serveFood();
        food2.serveFood();
    }
}

class FoodFactory {

    Food getFood(String name) {

        if (name.equals("FastFood")) {
            return new FastFood(name);
        } else {
            return new Fruit(name);
        }

    }
}

class Food {

    String name;

    Food(String name) {
        this.name = name;
    }

    void serveFood() {
        System.out.println("I'm serving " + this.name);
    }
}

class FastFood extends Food {

    FastFood(String name) {
        super(name);
    }
}

class Fruit extends Food {

    Fruit(String name) {
        super(name);
    }
}

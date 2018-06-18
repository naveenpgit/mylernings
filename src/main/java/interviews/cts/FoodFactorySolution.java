package interviews.cts;

public class FoodFactorySolution {
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

class Food {
    String name;
    Food(){}
    Food(String name) {
        this.name = name;
    }

    public void serveFood() {
        System.out.println("I'm serving " + name);
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

class FoodFactory extends Food {
    FoodFactory() {

    }

    FoodFactory(String name) {
        super(name);
    }

    Food getFood(String name) {
        switch (name) {
            case "FastFood":
                return new FastFood(name);
            case "Fruit":
                return new Fruit(name);
        }

        return null;
    }
}

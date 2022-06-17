package animals;

import food.Food;

public class Herbivore extends Animals {
    public Herbivore(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        System.out.println("Только трава!");
    }
}

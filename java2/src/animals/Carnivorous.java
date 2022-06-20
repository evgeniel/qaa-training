package animals;

import food.Food;

public class Carnivorous extends Animals {
    public Carnivorous(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        System.out.println("Только мясо!");
    }
}

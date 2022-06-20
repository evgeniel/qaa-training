package animals;

import food.Food;
import food.Meat;

public class Catfish extends Carnivorous implements Swim {

    public Catfish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("Сом плывет!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat) {
            System.out.println("Буду мясо!)");
            setSatiety(1);
        } else {
            System.out.println("Я не ем траву!");
        }
    }
}

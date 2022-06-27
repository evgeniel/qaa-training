package animals;

import aviary.AviarySize;
import food.Food;
import food.Meat;

public class Lion extends Carnivorous implements Run, Voice {
    public Lion(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void run() {
        System.out.println("Лев бегает!");
    }

    @Override
    public String voice() {
        return "Ррррааааввв!";
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

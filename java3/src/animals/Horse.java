package animals;

import aviary.AviarySize;
import food.Food;
import food.Grass;

public class Horse extends Herbivore implements Run, Voice {
    public Horse(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void run() {
        System.out.println("Лошадь бегает!");
    }

    @Override
    public String voice() {
        return "Иииихаха!";
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Grass) {
            System.out.println("Буду травку!)");
            setSatiety(1);
        } else {
            System.out.println("Я не ем мясо!");
        }
    }
}

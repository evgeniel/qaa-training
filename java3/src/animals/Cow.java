package animals;

import aviary.AviarySize;
import food.Food;
import food.Grass;

public class Cow extends Herbivore implements Run, Voice {
    public Cow(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void run() {
        System.out.println("Корова бегает!");
    }

    @Override
    public String voice() {
        return "Муу!";
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

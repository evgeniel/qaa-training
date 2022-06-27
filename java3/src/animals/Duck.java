package animals;

import aviary.AviarySize;
import food.Food;
import food.Grass;

public class Duck extends Herbivore implements Run, Swim, Fly, Voice {
    public Duck(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void fly() {
        System.out.println("Утка летает!");
    }

    @Override
    public void run() {
        System.out.println("Утка бегает!");
    }

    @Override
    public void swim() {
        System.out.println("Утка плавает!");
    }

    @Override
    public String voice() {
        return "Гагага!";
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

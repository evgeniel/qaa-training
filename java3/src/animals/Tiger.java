package animals;

import aviary.AviarySize;
import food.Food;
import food.Meat;

public class Tiger extends Carnivorous implements Run, Swim, Voice {
    public Tiger(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void run() {
        System.out.println("Тигр бегает!");
    }

    @Override
    public void swim() {
        System.out.println("Тигр плавает!");
    }

    @Override
    public String voice() {
        return "Рррр!";
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

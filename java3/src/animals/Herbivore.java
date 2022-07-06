package animals;

import aviary.AviarySize;
import exceptions.WrongFoodException;
import food.Food;
import food.Grass;
import food.Meat;

public class Herbivore extends Animals {

    public Herbivore(String name) {
        super(name);
    }

    public Herbivore(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) throw new WrongFoodException("Травоядные не едят мясо!");
        if (food instanceof Grass) {
            System.out.println("Буду травку!)");
            setSatiety(1);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Травоядное животное, сытость - " + getSatiety() + ", размер вольера - " + getAviarySize();
    }
}

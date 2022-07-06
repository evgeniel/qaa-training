package animals;

import aviary.AviarySize;
import exceptions.WrongFoodException;
import food.Food;
import food.Grass;
import food.Meat;

public class Carnivorous extends Animals {

    public Carnivorous(String name) {
        super(name);
    }

    public Carnivorous(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            System.out.println("Буду мясо!)");
            setSatiety(1);
        }
        if (food instanceof Grass) throw new WrongFoodException("Плотоядные не едят траву!");
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
        return "Плотоядное животное, сытость - " + getSatiety() + ", размер вольера - " + getAviarySize();
    }
}

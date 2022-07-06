package animals;

import aviary.AviarySize;
import exceptions.WrongFoodException;
import food.Food;

public abstract class Animals {

    private String name;
    private int satiety;
    private AviarySize aviarySize;

    public Animals(String name) {
        this.name = name;
    }

    public Animals(String name, AviarySize aviarySize) {
        this.name = name;
        this.aviarySize = aviarySize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public void setAviarySize(AviarySize aviarySize) {
        this.aviarySize = aviarySize;
    }

    public abstract void eat(Food food) throws WrongFoodException;

    @Override
    public String toString() {
        return "Животное " + name + ", сытость - " + satiety;
    }
}

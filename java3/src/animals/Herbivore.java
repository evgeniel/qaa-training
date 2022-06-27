package animals;

import aviary.AviarySize;
import food.Food;

public class Herbivore extends Animals {
    private AviarySize aviarySize;

    public Herbivore(String name) {
        super(name);
    }

    public Herbivore(String name, AviarySize aviarySize) {
        super(name);
        this.aviarySize = aviarySize;
    }

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public void setAviarySize(AviarySize aviarySize) {
        this.aviarySize = aviarySize;
    }

    @Override
    public void eat(Food food) {
        System.out.println("Только трава!");
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

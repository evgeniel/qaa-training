package animals;

import aviary.AviarySize;
import food.Food;

public class Carnivorous extends Animals {
    private AviarySize aviarySize;

    public Carnivorous(String name) {
        super(name);
    }

    public Carnivorous(String name, AviarySize aviarySize) {
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
        System.out.println("Только мясо!");
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

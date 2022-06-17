package animals;

import food.Food;

public abstract class Animals {
    private String name;
    private int satiety;

    public Animals(String name) {
        this.name = name;
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

    public abstract void eat(Food food);

    @Override
    public String toString() {
        return "Животное " + name + ", сытость - " + satiety;
    }
}

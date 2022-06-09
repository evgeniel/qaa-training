package model;

import java.util.Random;

public class Kotik {
    private static int catCount = 0;
    private int catSatiety;
    private String name;
    private int weight; //кг.
    private String meow = "";

    public Kotik() {
        catCount++;
    }

    public Kotik(String name, int weight, int catSatiety, String meow) {
        this.name = name;
        this.weight = weight;
        this.catSatiety = catSatiety;
        this.meow = meow;
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public int getCatSatiety() {
        return catSatiety;
    }

    public void setCatSatiety(int catSatiety) {
        this.catSatiety = catSatiety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    private boolean isHungry() {
        return catSatiety <= 0;
    }

    private boolean play() {
        if (!isHungry()) {
            catSatiety--;
            System.out.println("Я играю! :)");
            return true;
        } else {
            System.out.println("Я хочу есть! :(");
            eat();
            return false;
        }
    }

    private boolean sleep() {
        if (!isHungry()) {
            catSatiety--;
            System.out.println("Я сплю! :)");
            return true;
        } else {
            System.out.println("Я хочу есть! :(");
            eat();
            return false;
        }
    }

    private boolean chaseMouse() {
        if (!isHungry()) {
            catSatiety--;
            System.out.println("Я ловлю мышь! :)");
            return true;
        } else {
            System.out.println("Я хочу есть! :(");
            eat();
            return false;
        }
    }

    private boolean purr() {
        if (!isHungry()) {
            catSatiety--;
            System.out.println("Я мурлыкаю! :)");
            return true;
        } else {
            System.out.println("Я хочу есть! :(");
            eat();
            return false;
        }
    }

    private void eat() {
        eat(1, "кошачий корм");
    }

    private void eat(int catSatiety) {
        this.catSatiety += catSatiety;
        System.out.println("Я кушаю! :)");
    }

    private void eat(int catSatiety, String foodName) {
        this.catSatiety += catSatiety;
        System.out.println("Я покушал " + foodName + "! :)");
    }

    public void liveAnotherDay() {
        int randomNum = 0;
        for (int i = 0; i < 24; i++) {
            Random random = new Random();
            randomNum = random.nextInt(4) + 1;
            switch (randomNum) {
                case 1:
                    play();
                    break;
                case 2:
                    sleep();
                    break;
                case 3:
                    chaseMouse();
                    break;
                case 4:
                    purr();
                    break;
                case 5:
                    eat();
                    break;
            }
        }
    }

    public String toString() {
        return "\nДействия котика " + name + " за 24 часа:\n";
    }
}

package animals;

import aviary.AviarySize;

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
}

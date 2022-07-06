package animals;

import aviary.AviarySize;

public class Catfish extends Carnivorous implements Swim {

    public Catfish(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void swim() {
        System.out.println("Сом плывет!");
    }
}

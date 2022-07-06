package animals;

import aviary.AviarySize;

public class Lion extends Carnivorous implements Run, Voice {

    public Lion(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void run() {
        System.out.println("Лев бегает!");
    }

    @Override
    public String voice() {
        return "Ррррааааввв!";
    }
}

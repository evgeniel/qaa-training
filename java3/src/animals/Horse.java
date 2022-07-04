package animals;

import aviary.AviarySize;

public class Horse extends Herbivore implements Run, Voice {
    public Horse(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void run() {
        System.out.println("Лошадь бегает!");
    }

    @Override
    public String voice() {
        return "Иииихаха!";
    }
}

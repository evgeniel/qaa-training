package animals;

import aviary.AviarySize;

public class Cow extends Herbivore implements Run, Voice {

    public Cow(String name, AviarySize aviarySize) {
        super(name, aviarySize);
    }

    @Override
    public void run() {
        System.out.println("Корова бегает!");
    }

    @Override
    public String voice() {
        return "Муу!";
    }
}

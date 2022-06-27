package aviary;

import animals.Animals;
import animals.Carnivorous;
import animals.Herbivore;
import exceptions.WrongAviaryException;

import java.util.HashMap;
import java.util.Map;

public class Aviary<A extends Animals> {
    private final Map<String, Animals> aviary;
    private final A nameAviary;

    public Aviary(A nameAviary) {
        this.nameAviary = nameAviary;
        this.aviary = new HashMap<>();
    }

    public Map<String, Animals> getAviary() {
        return aviary;
    }

    public A getNameAviary() {
        return nameAviary;
    }

    public void add(String name, Animals animals) {
        if (animals instanceof Carnivorous) {
            new WrongAviaryException("Плотоядный не вмещается в вальер!", ((Carnivorous) animals).getAviarySize(), animals);
            aviary.put(name, animals);
        }
        if (animals instanceof Herbivore) {
            new WrongAviaryException("Травоядный не вмещается в вальер!", ((Herbivore) animals).getAviarySize(), animals);
            aviary.put(name, animals);
        }
    }

    public void delete(String name, Animals animals) {
        aviary.remove(name, animals);
    }

    public Animals getAnimal(String name) {
        return aviary.get(name);
    }
}

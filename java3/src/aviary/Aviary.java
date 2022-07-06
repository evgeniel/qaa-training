package aviary;

import animals.*;
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

    public void add(String name, Animals animals) throws WrongAviaryException {
        if (animals instanceof Carnivorous && nameAviary.getName().equals("Травоядные"))
            throw new WrongAviaryException("Плотоядный не должен быть в вальере травоядного!");
        if (animals instanceof Herbivore && nameAviary.getName().equals("Хищники"))
            throw new WrongAviaryException("Травоядный не должен быть в вальере плотоядного!");

        switch (animals.getAviarySize()) {
            case SMALL:
                if (animals instanceof Catfish) throw new WrongAviaryException("Сом не вмещается в вальер!");
                if (animals instanceof Cow) throw new WrongAviaryException("Корова не вмещается в вальер!");
                if (animals instanceof Duck) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Horse) throw new WrongAviaryException("Лошадь не вмещается в вальер!");
                if (animals instanceof Lion) throw new WrongAviaryException("Лев не вмещается в вальер!");
                if (animals instanceof Tiger) throw new WrongAviaryException("Тигр не вмещается в вальер!");
                break;
            case MIDDLE:
                if (animals instanceof Catfish) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Cow) throw new WrongAviaryException("Корова не вмещается в вальер!");
                if (animals instanceof Duck) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Horse) throw new WrongAviaryException("Лошадь не вмещается в вальер!");
                if (animals instanceof Lion) throw new WrongAviaryException("Лев не вмещается в вальер!");
                if (animals instanceof Tiger) {
                    aviary.put(name, animals);
                    return;
                }
                break;
            case BIG:
                if (animals instanceof Catfish) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Cow) throw new WrongAviaryException("Корова не вмещается в вальер!");
                if (animals instanceof Duck) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Horse) throw new WrongAviaryException("Лошадь не вмещается в вальер!");
                if (animals instanceof Lion) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Tiger) {
                    aviary.put(name, animals);
                    return;
                }
                break;
            case HUGE:
                if (animals instanceof Catfish) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Cow) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Duck) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Horse) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Lion) {
                    aviary.put(name, animals);
                    return;
                }
                if (animals instanceof Tiger) {
                    aviary.put(name, animals);
                    return;
                }
                break;
        }
    }

    public void delete(String name, Animals animals) {
        aviary.remove(name, animals);
    }

    public Animals getAnimal(String name) {
        return aviary.get(name);
    }
}

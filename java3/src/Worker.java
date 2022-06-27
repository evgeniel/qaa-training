import animals.Animals;
import animals.Carnivorous;
import animals.Herbivore;
import animals.Voice;
import exceptions.WrongFoodException;
import food.Food;

public class Worker {
    public void feed(Animals animals, Food food) {
        if (animals instanceof Carnivorous) {
            new WrongFoodException("Плотоядный не ест траву!", food, animals);
            animals.eat(food);
        }
        if (animals instanceof Herbivore) {
            new WrongFoodException("Травоядный не ест мясо!", food, animals);
            animals.eat(food);
        }
    }

    public void getVoice(Voice voice) {
        System.out.println(voice.voice());
    }
}

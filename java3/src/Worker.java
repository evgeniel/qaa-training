import animals.Animals;
import animals.Carnivorous;
import animals.Herbivore;
import animals.Voice;
import exceptions.WrongFoodException;
import food.Food;

public class Worker {
    public void feed(Animals animals, Food food) throws WrongFoodException {
        animals.eat(food);
    }

    public void getVoice(Voice voice) {
        System.out.println(voice.voice());
    }
}

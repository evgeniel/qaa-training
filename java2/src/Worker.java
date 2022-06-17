import animals.Animals;
import animals.Voice;
import food.Food;

public class Worker {
    public void feed(Animals animals, Food food) {
        animals.eat(food);
    }

    public void getVoice(Voice voice) {
        System.out.println(voice.voice());
    }
}

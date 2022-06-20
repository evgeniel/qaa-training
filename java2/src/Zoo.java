import animals.*;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) {
        Catfish catfish = new Catfish("Сомчик");
        Cow cow = new Cow("Маруся");
        Duck duck = new Duck("Дональд Дак");
        Horse horse = new Horse("Мустанг");
        Lion lion = new Lion("Король Лев");
        Tiger tiger = new Tiger("Амур");

        Grass grass = new Grass("Трава");
        Meat meat = new Meat("Мясо");

        Worker worker = new Worker();

        catfish.swim();
        catfish.eat(grass);
        worker.feed(catfish, meat);
        System.out.println(catfish);

        cow.run();
        cow.eat(grass);
        worker.feed(catfish, meat);
        worker.getVoice(cow);
        System.out.println(cow);

        duck.fly();
        duck.run();
        duck.swim();
        duck.eat(meat);
        worker.getVoice(duck);
        System.out.println(duck);

        horse.run();
        horse.voice();
        horse.eat(grass);
        worker.feed(horse, meat);
        System.out.println(horse);

        lion.run();
        worker.feed(lion, grass);
        worker.getVoice(lion);
        System.out.println(lion);

        tiger.run();
        tiger.swim();
        tiger.eat(meat);
        worker.getVoice(tiger);
        System.out.println(tiger);

        Swim[] pond = {catfish, duck, tiger};
        for (Swim i : pond) {
            i.swim();
        }
    }
}

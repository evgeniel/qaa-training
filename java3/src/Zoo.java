import animals.*;
import aviary.Aviary;
import aviary.AviarySize;
import exceptions.WrongAviaryException;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) throws WrongAviaryException {
        Aviary aviaryCarnivorous = new Aviary(new Carnivorous("Хищник"));
        Aviary aviaryHerbivore = new Aviary(new Herbivore("Травоядные"));

        Catfish catfish = new Catfish("Сомчик", AviarySize.MIDDLE);
        Cow cow = new Cow("Маруся", AviarySize.HUGE);
        Duck duck = new Duck("Дональд Дак", AviarySize.SMALL);
        Horse horse = new Horse("Мустанг", AviarySize.BIG);
        Lion lion = new Lion("Король Лев", AviarySize.BIG);
        Lion lionSimba = new Lion("Симба", AviarySize.MIDDLE);
        Tiger tiger = new Tiger("Амур", AviarySize.MIDDLE);

        Grass grass = new Grass("Трава");
        Meat meat = new Meat("Мясо");

        aviaryCarnivorous.add(catfish.getName(), catfish);
        aviaryCarnivorous.add(lion.getName(), lion);
        aviaryCarnivorous.add(lionSimba.getName(), lionSimba);

        aviaryCarnivorous.delete(catfish.getName(), catfish);

        aviaryHerbivore.add(cow.getName(), cow);
        aviaryHerbivore.add(horse.getName(), horse);

        System.out.println(aviaryCarnivorous.getAviary());
        System.out.println(aviaryCarnivorous.getAnimal(lion.getName()));
        System.out.println(aviaryHerbivore.getAviary());

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

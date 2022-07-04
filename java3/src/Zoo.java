import animals.*;
import aviary.Aviary;
import aviary.AviarySize;
import exceptions.WrongAviaryException;
import exceptions.WrongFoodException;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) throws WrongAviaryException, WrongFoodException {
        Aviary aviaryCarnivorous = new Aviary(new Carnivorous("Хищники"));
        Aviary aviaryHerbivore = new Aviary(new Herbivore("Травоядные"));

        Catfish catfish = new Catfish("Сомчик", AviarySize.SMALL);
        Cow cow = new Cow("Маруся", AviarySize.HUGE);
        Duck duck = new Duck("Дональд Дак", AviarySize.SMALL);
        Horse horse = new Horse("Мустанг", AviarySize.BIG);
        Lion lion = new Lion("Король Лев", AviarySize.BIG);
        Lion lionSimba = new Lion("Симба", AviarySize.MIDDLE);
        Tiger tiger = new Tiger("Амур", AviarySize.MIDDLE);

        Grass grass = new Grass("Трава");
        Meat meat = new Meat("Мясо");

        aviaryCarnivorous.add(cow.getName(), cow); //проверка того что, подходит ли вольер травоядному или плотоядному

        aviaryCarnivorous.add(catfish.getName(), catfish); //проверка того что, вмещается ли животное в вольер
        aviaryCarnivorous.add(lion.getName(), lion); //добавление животного в вольер
        aviaryCarnivorous.add(lionSimba.getName(), lionSimba); //проверка того что, вмещается ли животное в вольер

        aviaryCarnivorous.delete(catfish.getName(), catfish); //удаление животного из вольера

        aviaryHerbivore.add(cow.getName(), cow); //добавление животного в вольер
        aviaryHerbivore.add(horse.getName(), horse); //проверка того что, вмещается ли животное в вольер
        aviaryHerbivore.add(duck.getName(), duck); //добавление животного в вольер

        System.out.println(aviaryCarnivorous.getAviary());
        System.out.println(aviaryCarnivorous.getAnimal(lion.getName()));
        System.out.println(aviaryHerbivore.getAviary());

        Worker worker = new Worker();

        worker.feed(catfish, grass); //проверка того что, ест ли плотоядный траву
        catfish.eat(grass); //корм животного
    }
}

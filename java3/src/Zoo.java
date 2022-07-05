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

        //aviaryCarnivorous.add(cow.getName(), cow); //проверка того что, подходит ли вольер травоядному или плотоядному

        //aviaryCarnivorous.add(catfish.getName(), catfish); //проверка того что, вмещается ли животное в вольер

        aviaryCarnivorous.add(lion.getName(), lion); //добавление животного в вольер
        aviaryCarnivorous.add(tiger.getName(), tiger); //добавление животного в вольер
        System.out.println(aviaryCarnivorous.getAviary());
        aviaryCarnivorous.delete(lion.getName(), lion); //удаление животного из вольера
        System.out.println(aviaryCarnivorous.getAviary());

        Worker worker = new Worker();

        //worker.feed(catfish, grass); //проверка того что, ест ли плотоядный траву
        System.out.println(catfish.getSatiety());
        catfish.eat(meat); //корм животного*/
        System.out.println(catfish.getSatiety());
    }
}

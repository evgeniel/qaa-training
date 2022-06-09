import model.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik kotik1 = new Kotik("Luna", 3, 5, "Мяу");
        Kotik kotik2 = new Kotik();

        kotik2.setName("Polya");
        kotik2.setWeight(2);
        kotik2.setCatSatiety(3);
        kotik2.setMeow("Мрр");

        System.out.println(kotik1);
        kotik1.liveAnotherDay();
        System.out.println(kotik2);
        kotik2.liveAnotherDay();

        System.out.println(compareCatTalk(kotik1.getMeow(), kotik2.getMeow()));
        System.out.println("Количество котиков: " + Kotik.getCatCount());

    }

    public static String compareCatTalk(String firstCat, String secondCat) {
        if (firstCat.equals(secondCat)) {
            return "\nОдинаковый разговор";
        } else {
            return "\nРазный разговор";
        }
    }
}

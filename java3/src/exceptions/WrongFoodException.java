package exceptions;

import animals.*;
import food.Food;
import food.Grass;
import food.Meat;

public class WrongFoodException extends Exception {
    public WrongFoodException(String message) {
        super(message);
    }

    public WrongFoodException(String message, Food food, Animals animals) {
        super(message);
        wrongFoodException(food, animals);
    }

    public void wrongFoodException(Food food, Animals animals) {
        try {
            if (food instanceof Grass) {
                if (animals instanceof Catfish) throw new WrongFoodException(getMessage());
                if (animals instanceof Cow) {
                    return;
                }
                if (animals instanceof Duck) {
                    return;
                }
                if (animals instanceof Horse) {
                    return;
                }
                if (animals instanceof Lion) throw new WrongFoodException(getMessage());
                if (animals instanceof Tiger) throw new WrongFoodException(getMessage());
            }
            if (food instanceof Meat) {
                if (animals instanceof Catfish) {
                    return;
                }
                if (animals instanceof Cow) throw new WrongFoodException(getMessage());
                if (animals instanceof Duck) throw new WrongFoodException(getMessage());
                if (animals instanceof Horse) throw new WrongFoodException(getMessage());
                if (animals instanceof Lion) {
                    return;
                }
                if (animals instanceof Tiger) {
                    return;
                }
            }
        } catch (WrongFoodException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

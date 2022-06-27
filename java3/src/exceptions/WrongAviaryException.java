package exceptions;

import animals.*;
import aviary.AviarySize;

public class WrongAviaryException extends Exception {

    public WrongAviaryException(String message, AviarySize aviarySize, Animals animals) {
        super(message);
        wrongAviaryException(aviarySize, animals);
    }

    public WrongAviaryException(String message) {
        super(message);
    }

    public void wrongAviaryException(AviarySize aviarySize, Animals animals) {
        try {
            switch (aviarySize) {
                case SMALL:
                    if (animals instanceof Catfish) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Cow) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Duck) {
                        return;
                    }
                    if (animals instanceof Horse) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Lion) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Tiger) throw new WrongAviaryException(getMessage());
                    break;
                case MIDDLE:
                    if (animals instanceof Catfish) {
                        return;
                    }
                    if (animals instanceof Cow) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Duck) {
                        return;
                    }
                    if (animals instanceof Horse) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Lion) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Tiger) {
                        return;
                    }
                    break;
                case BIG:
                    if (animals instanceof Catfish) {
                        return;
                    }
                    if (animals instanceof Cow) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Duck) {
                        return;
                    }
                    if (animals instanceof Horse) throw new WrongAviaryException(getMessage());
                    if (animals instanceof Lion) {
                        return;
                    }
                    if (animals instanceof Tiger) {
                        return;
                    }
                    break;
                case HUGE:
                    if (animals instanceof Catfish) {
                        return;
                    }
                    if (animals instanceof Cow) {
                        return;
                    }
                    if (animals instanceof Duck) {
                        return;
                    }
                    if (animals instanceof Horse) {
                        return;
                    }
                    if (animals instanceof Lion) {
                        return;
                    }
                    if (animals instanceof Tiger) {
                        return;
                    }
                    break;
            }
        } catch (WrongAviaryException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

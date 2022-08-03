package exceptions;

/**
 * Исключение в случае неверного ввода выражения
 */
public class InvalidNumericExpression extends RuntimeException {

    public InvalidNumericExpression(String message) {
        super(message);
    }
}

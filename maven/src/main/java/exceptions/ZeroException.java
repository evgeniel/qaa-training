package exceptions;

/**
 * Исключение в случае деления на ноль
 */
public class ZeroException extends RuntimeException {

    public ZeroException(String message) {
        super(message);
    }
}

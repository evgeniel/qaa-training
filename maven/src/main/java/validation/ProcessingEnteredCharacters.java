package validation;

public class ProcessingEnteredCharacters {

    /**
     * Переменные для певрого числа и второго числа
     */
    private int firstNumber;
    private int secondNumber;

    /**
     * Метод разделяет первое число и второе число по пробелу
     * и присваивает в соответствующие переменные
     * @param numericExpression введенное выражение которое надо разделить
     */
    public void processingEnteredCharacters(String numericExpression) {
        String[] items = numericExpression.split(" ");
        firstNumber = Integer.parseInt(items[0]);
        secondNumber = Integer.parseInt(items[2]);
    }

    /**
     * Возвращает первое число
     * @return первое число
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * Возвращает второе число
     * @return второе число
     */
    public int getSecondNumber() {
        return secondNumber;
    }
}

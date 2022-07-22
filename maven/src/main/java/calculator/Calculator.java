package calculator;

import exceptions.ZeroException;
import validation.ProcessingEnteredCharacters;
import validation.Validation;

public class Calculator {

    /**
     * Переменные введенного выражения, результат операции,
     * объект класса проверки выражения и разделения на первое и второе число
     */
    private String numericExpression;
    private int result;
    private ProcessingEnteredCharacters processingEnteredCharacters;
    private Validation validation;

    /**
     * Конструктор класса
     */
    public Calculator() {
        processingEnteredCharacters = new ProcessingEnteredCharacters();
        validation = new Validation();
    }

    /**
     * Возвращает выражение
     * @return выражение
     */
    public String getNumericExpression() {
        return numericExpression;
    }

    /**
     * Устанавливает выражение введенное, через проверку корректности
     * @param numericExpression выражение
     */
    public void setNumericExpression(String numericExpression) {
        if (validation.validateInputString(numericExpression)) {
            this.numericExpression = numericExpression;
        }
    }

    /**
     * Возвращает результат операции
     * @return операция
     */
    public int getResult() {
        return result;
    }

    /**
     * Метод совершает операции сложения, вычитания, деления, умножения
     * @throws ZeroException проверяется делится ли на ноль
     */
    public void performOperation() throws ZeroException {
        processingEnteredCharacters.processingEnteredCharacters(numericExpression);
        if (numericExpression.contains("+")) {
            result = processingEnteredCharacters.getFirstNumber() + processingEnteredCharacters.getSecondNumber();
        }
        if (numericExpression.contains("-")) {
            result = processingEnteredCharacters.getFirstNumber() - processingEnteredCharacters.getSecondNumber();
        }
        if (numericExpression.contains("/") || numericExpression.contains(":")) {
            if (processingEnteredCharacters.getSecondNumber() == 0) throw new ZeroException("На ноль делить нельзя!");
            result = processingEnteredCharacters.getFirstNumber() / processingEnteredCharacters.getSecondNumber();;
        }
        if (numericExpression.contains("*")) {
            result = processingEnteredCharacters.getFirstNumber() * processingEnteredCharacters.getSecondNumber();
        }
    }

    /**
     * Метод для печати результата операции
     * @return
     */
    @Override
    public String toString() {
        return "Результат: " + result;
    }
}

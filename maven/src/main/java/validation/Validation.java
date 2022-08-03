package validation;

import exceptions.InvalidNumericExpression;

/**
 * Класс для проверки ввода выражения в правильном формате
 */
public class Validation {

    /**
     * Проверяет что введена число пробел оператор пробел и число в виде формата "5 + 5"
     *
     * @param numericExpression введенное выражение
     * @return если проверка прошла успешно то возвращает true
     * @throws InvalidNumericExpression если проверка не прошла успешно то исключение
     */
    public boolean validateInputString(String numericExpression) throws InvalidNumericExpression {
        if (numericExpression.matches("^[0-9]+\\s[*+/:-]\\s[0-9]+$") && !numericExpression.isEmpty()) {
            return true;
        } else {
            throw new InvalidNumericExpression("Вы ввели неправильное выражение!");
        }
    }
}

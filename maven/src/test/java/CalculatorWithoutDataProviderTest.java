import calculator.Calculator;
import exceptions.InvalidNumericExpression;
import exceptions.ZeroException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов для проверки функционала клькулятора без DataProvider
 */
public class CalculatorWithoutDataProviderTest {

    /**
     * Создание переменной с классом Calculator
     */
    private Calculator calculator;

    /**
     * Метод который выполняется перед каждым тестом, создает объект класса
     */
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Позитивная проверка сложения двух чисел
     */
    @Test
    public void testAddition() {
        String str = "5 + 5";
        calculator.setNumericExpression(str);
        calculator.performOperation();
        assertEquals(calculator.getResult(), 10);
    }

    /**
     * Позитивная проверка вычитания одного числа другим
     */
    @Test
    public void testSubtraction() {
        String str = "10 - 5";
        calculator.setNumericExpression(str);
        calculator.performOperation();
        assertEquals(calculator.getResult(), 5);
    }

    /**
     * Позитивная проверка деления одного числа на другое
     */
    @Test
    public void testDivision() {
        String str = "10 / 5";
        calculator.setNumericExpression(str);
        calculator.performOperation();
        assertEquals(calculator.getResult(), 2);
    }

    /**
     * Позитивная проверка умножения двух чисел
     */
    @Test
    public void testMultiplication() {
        String str = "10 * 10";
        calculator.setNumericExpression(str);
        calculator.performOperation();
        assertEquals(calculator.getResult(), 100);
    }

    /**
     * Проверка исключения в случае неверного ввода выражения
     */
    @Test(expectedExceptions = InvalidNumericExpression.class)
    public void testInvalidNumericExpression() {
        ArrayList<String> arrayStr = new ArrayList<String>();
        arrayStr.add("пять плюс пять");
        arrayStr.add("5-5");
        arrayStr.add("6+ 7");
        arrayStr.add("5.67 * 5");

        for (String str : arrayStr) {
            calculator.setNumericExpression(str);
        }
    }

    /**
     * Проверка исключение в случае деления на ноль
     */
    @Test(expectedExceptions = ZeroException.class)
    public void testZeroException() {
        String str = "10 / 0";
        calculator.setNumericExpression(str);
        calculator.performOperation();
    }
}

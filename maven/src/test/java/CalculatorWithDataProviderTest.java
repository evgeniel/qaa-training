import calculator.Calculator;
import exceptions.InvalidNumericExpression;
import exceptions.ZeroException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов для проверки функционала клькулятора с DataProvider
 */
public class CalculatorWithDataProviderTest {

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
     * DataProvider с тестовыми данными и ожидаемым результатом для тестов
     *
     * @return двумерный массив объектвой (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestAndExpectedData() {
        return new String[][]{
                {"5 + 5", "10"},
                {"10 - 5", "5"},
                {"10 / 5", "2"},
                {"10 * 10", "100"}
        };
    }

    /**
     * DataProvider с тестовыми данными для теста в случае неверного ввода выражения
     *
     * @return массив объектвой (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestInvalidNumericExpressionData() {
        return new String[][]{
                {"пять плюс пять"},
                {"5-5"},
                {"6+ 7"},
                {"5.67 * 5"}
        };
    }

    /**
     * Позитивная проверка сложения, вычитания, деления, умножения чисел
     *
     * @param str      тестовые данные из DataProvider
     * @param expected ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "getTestAndExpectedData")
    public void testOperation(String str, String expected) {
        calculator.setNumericExpression(str);
        calculator.performOperation();
        assertEquals(calculator.getResult(), Integer.parseInt(expected));
    }

    /**
     * Проверка исключения в случае неверного ввода выражения
     *
     * @param str тестовые данные из DataProvider
     */
    @Test(dataProvider = "getTestInvalidNumericExpressionData", expectedExceptions = InvalidNumericExpression.class)
    public void testInvalidNumericExpression(String str) {
        calculator.setNumericExpression(str);
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

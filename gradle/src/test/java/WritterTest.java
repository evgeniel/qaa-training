import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Тест метода getText
 */
@Epic("Writter")
@Feature("Тест метода getText")
public class WritterTest {

    /**
     * Создание переменной с классом Writter
     */
    private Writter writter;

    /**
     * Метод который выполняется перед каждым тестом, создает объект класса
     */
    @BeforeMethod
    public void setUp() {
        writter = new Writter();
    }

    /**
     * Ппроверка печати метода getText
     */
    @Test
    @Owner(value = "Васияров Евгений Владимирович")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Тест без DataProvider")
    @Description("Тест печати метода getText")
    public void testAddition() {
        assertEquals(writter.getText(), "Hello World!");
    }
}

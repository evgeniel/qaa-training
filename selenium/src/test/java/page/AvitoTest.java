package page;

import config.AvitoTestsConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.AvitoPage;

/**
 * Набор тестов для проверки функционала Авито
 */
@Epic("AvitoTest")
@Feature("Avito functionality test")
public class AvitoTest extends BaseTest {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final AvitoTestsConfig config = ConfigFactory.create(AvitoTestsConfig.class, System.getenv());

    /**
     * Тестовый метод для осуществления поиска в Авито
     */
    @Test
    @Owner(value = "Васияров Евгений Владимирович")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Тесты поиска товаров с сортировкой по фото и цене")
    @Description("Тест поиска товара только с фото и с сортировкой Дороже")
    public void avitoTest() {
        //получение доступа к методам класса AvitoPage для взаимодействия с элементами страницы
        new AvitoPage(driver).selectingCategoryOfficeEquipment()
                .inputPinter(config.inputSearch()).activationCheckboxOnlyWithPhoto()
                .openingListRegions().regionEntry(config.regionInputField()).adsButtonClick()
                .selectionSortListExpensive().valuePriceFirstFiveItems(5);
    }
}
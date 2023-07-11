package cucumber.steps;

import config.BaseConfig;
import enums.Category;
import enums.City;
import enums.Sort;
import enums.StringForSearch;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AvitoPage;

import java.time.Duration;

import static utils.ScreenHelper.makeScreenShot;

public class MyStepdefs {

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());
    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;
    /**
     * Экземпляр страницы с которой происходит взаимодействие
     */
    private AvitoPage avitoPage;

    @ParameterType(".*")
    public Category cat(String cat) {
        return Category.valueOf(cat);
    }

    @ParameterType(".*")
    public StringForSearch stringForSearch(String stringForSearch) {
        return StringForSearch.valueOf(stringForSearch);
    }

    @ParameterType(".*")
    public City city(String city) {
        return City.valueOf(city);
    }

    @ParameterType(".*")
    public Sort sort(String sort) {
        return Sort.valueOf(sort);
    }

    @When("Follow the link Avito")
    public void followTheLinkAvito() {
        // Установка настройки с путем к google драйверу
        System.setProperty(config.driverProperty(), config.driverPath());

        // создание экземпляра драйвера
        driver = new ChromeDriver();

        // открытие страницы по url
        driver.get(config.url());

        // разворот страницы на полное окно
        driver.manage().window().maximize();

        //Делаем скриншот
        makeScreenShot(driver);

        //Ожидание по умолчанию 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Создание объекта страницы
        avitoPage = new AvitoPage(driver);
    }

    @Then("Select category {cat}")
    public void selectCategoryCategory(Category cat) {
        avitoPage.selectingCategory(cat.getValue());
    }

    @Then("In the search field write {stringForSearch}")
    public void inTheSearchFieldWriteStringForSearch(StringForSearch stringForSearch) {
        avitoPage.inputPinter(stringForSearch.getValue());
    }

    @Then("Click on the dropdown list of regions")
    public void clickOnTheDropdownListOfRegions() {
        avitoPage.openingListRegions();
    }

    @Then("Enter region {city}")
    public void enterRegionCity(City city) {
        avitoPage.regionEntryAll(city.getValue());
    }

    @Then("Click on the button Show N ads")
    public void clickOnTheButtonShowNAds() {
        avitoPage.adsButtonClick();
    }

    @Then("Activate the checkbox With photo only")
    public void activateTheCheckboxWithPhotoOnly() {
        avitoPage.activationCheckboxOnlyWithPhoto();
    }

    @Then("Select {sort} in the sort drop-down list")
    public void selectSortInTheSortDropDownList(Sort sort) {
        avitoPage.selectionSortList(sort.getValue());
    }

    @Then("Output to the console Price value of the first {int} goods")
    public void OutputToTheConsolePriceValueOfTheFirstQuantityGoods(int quantity) {
        avitoPage.valuePriceFirstFiveItems(quantity);
    }

    @Then("Close browser")
    public void closeBrowser() {
        // остановка работы драйвера
        driver.close();
    }
}

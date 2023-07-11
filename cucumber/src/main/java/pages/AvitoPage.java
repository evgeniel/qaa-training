package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilVisible;

public class AvitoPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    /**
     * определение локатора поля категории
     */
    @FindBy(xpath = "//*[@id=\"category\"]")
    private WebElement category;
    /**
     * определение локатора категории “Оргтехника и расходники”
     */
    @FindBy(xpath = "//*[@id=\"category\"]/*[contains(text(), \"Оргтехника и расходники\")]")
    private WebElement officeEquipment;
    /**
     * определение локатора поле ввода поиска
     */
    @FindBy(xpath = "//*[@data-marker=\"search-form/suggest\"]")
    private WebElement searchInput;
    /**
     * определение локатора кнопки "Поиск"
     */
    @FindBy(xpath = "//*[@data-marker=\"search-form/submit-button\"]")
    private WebElement searchBt;
    /**
     * определение локатора чекбокса "только с фото"
     */
    @FindBy(xpath = "//*[@class=\"filters-root-_F_Zp\"]//*[contains(text(), \"только с фото\")]")
    private WebElement onlyWithPhoto;
    /**
     * определение локатора списка регионов
     */
    @FindBy(xpath = "//*[@data-marker=\"search-form/region\"]")
    private WebElement listOfRegions;
    /**
     * определение локатора поле ввода региона
     */
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[1]/div[2]/div/input")
    private WebElement regionInputField;
    /**
     * определение локатора выбора региона
     */
    @FindBy(xpath = "//*[@data-marker=\"suggest-list\"]//*[contains(text(), \"Владивосток\")]")
    private WebElement regionSelection;
    /**
     * определение локатора кнопки "Показать n объявлений"
     */
    @FindBy(xpath = "//*[@data-marker=\"popup-location/save-button\"]")
    private WebElement adsBtn;
    /**
     * определение локатора списка сортировки
     */
    @FindBy(xpath = "//*[@class=\"index-topPanel-McfCA\"]//*[@class=\"select-select-IdfiC\"]")
    private WebElement sortList;
    /**
     * определение локатора пункта "Дороже" в списке сортировки
     */
    @FindBy(xpath = "//*[@class=\"index-topPanel-McfCA\"]//*[@class=\"select-select-IdfiC\"]/*[contains(text(), \"Дороже\")]")
    private WebElement itemExpensive;

    public AvitoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * метод для выбора категории “Оргтехника и расходники”
     */
    @Step("Выбор категории “Оргтехника и расходники”")
    public AvitoPage selectingCategoryOfficeEquipment() {
        waitUntilVisible(driver, category);
        category.click();
        officeEquipment.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для выбора категори
     */
    public AvitoPage selectingCategory(String element) {
        waitUntilVisible(driver, category);
        category.click();
        driver
                .findElement(By.xpath("//*[@id=\"category\"]/*[contains(text(), \"" + element + "\")]"))
                .click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для ввода в поле поиска “Принтер”
     */
    @Step("Ввод в поле поиска “Принтер”")
    public AvitoPage inputPinter(String printer) {
        waitUntilVisible(driver, searchInput);
        searchInput.sendKeys(printer);
        //searchBt.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для активации чекбокса “только с фото”
     */
    @Step("Активация чекбокса “только с фото”")
    public AvitoPage activationCheckboxOnlyWithPhoto() {
        waitUntilVisible(driver, onlyWithPhoto);
        onlyWithPhoto.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для открытия выпадающего списка регионов
     */
    @Step("Открытие выпадающего списка регионов")
    public AvitoPage openingListRegions() {
        waitUntilVisible(driver, listOfRegions);
        listOfRegions.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для ввода региона
     */
    @Step("Ввод региона")
    public AvitoPage regionEntry(String region) {
        waitUntilVisible(driver, regionInputField);
        regionInputField.sendKeys(region);
        regionSelection.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для ввода всех регионов
     */
    @Step("Ввод региона")
    public AvitoPage regionEntryAll(String region) {
        waitUntilVisible(driver, regionInputField);
        regionInputField.sendKeys(region);
        //regionSelection.click();
        driver
                .findElement(By
                        .xpath("//*[@data-marker=\"suggest-list\"]//*[contains(text(), \"" + region + "\")]"))
                .click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для нажатия кнопки "Показать n объявлений"
     */
    @Step("Нажатие кнопки \"Показать n объявлений\"")
    public AvitoPage adsButtonClick() {
        waitUntilVisible(driver, adsBtn);
        adsBtn.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для выбора в выпадающем списке сортировки “Дороже”
     */
    @Step("Выбор в выпадающем списке сортировки “Дороже”")
    public AvitoPage selectionSortListExpensive() {
        waitUntilVisible(driver, sortList);
        sortList.click();
        itemExpensive.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * метод для выбора в выпадающем списке сортировки
     */
    @Step("Выбор в выпадающем списке сортировки")
    public AvitoPage selectionSortList(String element) {
        waitUntilVisible(driver, sortList);
        sortList.click();
        //itemExpensive.click();
        driver
                .findElement(By
                        .xpath("//*[@class=\"index-topPanel-McfCA\"]//*[@class=\"select-select-IdfiC\"]/*[contains(text(), \"" + element + "\")]"))
                .click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод получения элемента по номеру
     */
    private WebElement getItemPriceElementByNumber(int elementNumber) {
        return driver.findElement(By.xpath("//*[@data-marker=\"catalog-serp\"]/div[" + elementNumber + "]//*[@itemprop=\"price\"]"));
    }

    /**
     * метод для вывода в консоль Значение цены первых 5 товаров
     */
    @Step("Вывод в консоль Значение цены первых 5 товаров")
    public void valuePriceFirstFiveItems(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println("Цена " + i + " товара: " + getItemPriceElementByNumber(i).getAttribute("content"));
        }
    }
}


package enums;

public enum Category {
    OFFICE_EQUIPMENT("Оргтехника и расходники"),
    PRODUCTS_COMPUTER("Товары для компьютера");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

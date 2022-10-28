package enums;

public enum StringForSearch {
    PRINTER("Принтер\n"),
    MONITOR("Монитор\n");

    private final String value;

    StringForSearch(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

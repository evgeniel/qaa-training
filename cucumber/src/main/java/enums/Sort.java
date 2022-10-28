package enums;

public enum Sort {
    DEAR("Дороже"),
    CHEAP("Дешевле");

    private final String value;

    Sort(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


package enums;

public enum City {
    VLADIVOSTOK("Владивосток"),
    IRKUTSK("Иркутск");

    private final String value;

    City(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

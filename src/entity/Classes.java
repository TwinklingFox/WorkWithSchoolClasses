package entity;

public enum Classes {
    UNKNOWN ("Неизвестно"),
    FIRSTA ("1А"),
    FIRSTB ("1Б"),
    FIFTHA ("5А"),
    FIFTHB ("5Б"),
    TENTHA ("10А"),
    TENTHB ("10Б");


    String title;

    Classes(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

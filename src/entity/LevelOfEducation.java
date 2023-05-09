package entity;

public enum LevelOfEducation {
    UNKNOWN ("Неизвестно"),
    PRIMARY ("Начальная"),
    SECONDARY ("Средняя"),
    HIGH ("Старшая");

    final String title;

    LevelOfEducation(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

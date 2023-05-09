package entity;

public enum StatusOfWork {
    UNKNOWN ("Неизвестно"),
    TEACHER ("Учитель"),
    HEADMASTER ("Директор");

    final String title;

    StatusOfWork(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

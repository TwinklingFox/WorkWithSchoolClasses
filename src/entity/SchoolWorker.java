package entity;

import java.util.Objects;

public class SchoolWorker extends Person{
    private Integer salary;
    private StatusOfWork statusOfWork;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public StatusOfWork getStatusOfWork() {
        return statusOfWork;
    }

    public void setStatusOfWork(StatusOfWork statusOfWork) {
        this.statusOfWork = statusOfWork;
    }

    public SchoolWorker() {
        setName("Пусто");
        setSurname("Пусто");
        statusOfWork = StatusOfWork.UNKNOWN;
    }

    public SchoolWorker(String name, String surname, int age, int salary, StatusOfWork statusOfWork) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.salary = salary;
        this.statusOfWork = statusOfWork;
    }

    public SchoolWorker(String name, String surname, int age) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        statusOfWork = StatusOfWork.UNKNOWN;
    }

    @Override
    public void sayAboutYourself() {
        System.out.println("Меня зовут " + getName() + " " + getSurname() + ".\nМне " + getAge() + ".");
        System.out.println("Моя зарплата: " + salary + ".\nМоя профессия: " + statusOfWork + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolWorker that = (SchoolWorker) o;
        return salary == that.salary && Objects.equals(statusOfWork, that.statusOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, statusOfWork);
    }

    @Override
    public String toString() {
        return "Школьный работник," + getName() + "," + getSurname() + "," + getAge() + "," + salary + "," + statusOfWork;
    }
}

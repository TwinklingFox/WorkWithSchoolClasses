package entity;

import java.util.Objects;

public class Headmaster extends SchoolWorker{
    private Integer buildingsInManagement;

    public Headmaster() {
        setName("Пусто");
        setSurname("Пусто");
        setStatusOfWork(StatusOfWork.HEADMASTER);
    }

    public Headmaster(String name, String surname, int age, int salary, int buildingsInManagement) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setSalary(salary);
        setStatusOfWork(StatusOfWork.HEADMASTER);
        this.buildingsInManagement = buildingsInManagement;
    }

    public Headmaster(String name, String surname, int age) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        setStatusOfWork(StatusOfWork.HEADMASTER);
    }

    @Override
    public void sayAboutYourself() {
        super.sayAboutYourself();
        System.out.println("Кол-во корпусов в моём подчинении: " + buildingsInManagement + ".");
    }

    @Override
    public String toString() {
        return "Директор," + getName() + "," + getSurname() + "," + getAge() + "," + getSalary() + "," + getStatusOfWork() +
                "," + buildingsInManagement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Headmaster that = (Headmaster) o;
        return buildingsInManagement == that.buildingsInManagement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buildingsInManagement);
    }
}

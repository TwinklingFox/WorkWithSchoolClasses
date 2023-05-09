package entity;

import java.util.Objects;

public class Teacher extends SchoolWorker{
    private Classes classes;
    private LevelOfEducation levelOfEducation;

    public Teacher() {
        setName("Пусто");
        setSurname("Пусто");
        setStatusOfWork(StatusOfWork.TEACHER);
        classes = Classes.UNKNOWN;
        levelOfEducation = LevelOfEducation.UNKNOWN;
    }

    public Teacher(String name, String surname, int age, int salary, Classes classes, LevelOfEducation levelOfEducation) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setSalary(salary);
        setStatusOfWork(StatusOfWork.TEACHER);
        this.classes = classes;
        this.levelOfEducation = levelOfEducation;
    }

    public Teacher(String name, String surname, int age) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        setStatusOfWork(StatusOfWork.TEACHER);
        classes = Classes.UNKNOWN;
        levelOfEducation = LevelOfEducation.UNKNOWN;
    }

    @Override
    public void sayAboutYourself() {
        super.sayAboutYourself();
        System.out.println("Класс: " + classes + ".\nШкола: " + levelOfEducation + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(classes, teacher.classes) && Objects.equals(levelOfEducation, teacher.levelOfEducation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classes, levelOfEducation);
    }

    @Override
    public String toString() {
        return "Учитель," + getName() + "," + getSurname() + "," + getAge() + "," + getSalary() + "," + getStatusOfWork() +
                "," + classes + "," + levelOfEducation;
    }
}

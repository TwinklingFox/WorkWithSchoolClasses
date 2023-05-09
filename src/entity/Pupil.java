package entity;

import java.util.Objects;

public class Pupil extends Person{
    private Classes className;
    private float averageMark;

    public Pupil() {
        setName("Пусто");
        setSurname("Пусто");
        className = Classes.UNKNOWN;
    }

    public Pupil(String name, String surname, int age, Classes className, float averageMark){
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.className = className;
        this.averageMark = averageMark;
    }

    public Pupil(String name, String surname, int age){
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        className = Classes.UNKNOWN;
    }

    @Override
    public void sayAboutYourself() {
        System.out.println("Меня зовут " + getName() + " " + getSurname() + ".\nМне " + getAge() + ".");
        System.out.println("Я в " + className + " классе.\nМой средний балл: " + averageMark + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pupil pupil = (Pupil) o;
        return Float.compare(pupil.averageMark, averageMark) == 0 && Objects.equals(className, pupil.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), className, averageMark);
    }

    @Override
    public String toString() {
        //return getName() + " " + getSurname() + "; возраст: " + getAge() + "; класс: " + className + "; средний балл: " + averageMark;
        return "Ученик," + getName() + "," + getSurname() + "," + getAge() + "," + className + "," + averageMark;
    }
}

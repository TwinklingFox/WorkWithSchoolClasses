package save;

import entity.Person;

import java.util.ArrayList;
import java.util.List;

public class RuntimeSaver implements ISaver{

    List<Person> people = new ArrayList<>();

    @Override
    public void save(Person person) {
        people.add(person);
    }

    @Override
    public void drop(Person person) {
        if (people.contains(person)) {
            people.remove(person);
        } else {
            System.out.println("Ошибка! Такого человека нет в списке.");
        }
    }

    @Override
    public void dropByPosition(Integer position) {
        if (people.size() - 1 >= position && position >= 0) {
            people.remove((int) position);
        } else {
            System.out.println("Ошибка! Человека под таким номером не существует.");
        }
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public List<Person> getAllByName(String nameOfPerson) {
        List<Person> allByName = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equals(nameOfPerson)) {
                allByName.add(person);
            }
        }
        if (!allByName.isEmpty()) {
            return allByName;
        }
        return null;
    }

    @Override
    public List<Person> getAllByAge(Integer ageOfPerson) {
        List<Person> allByAge = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge().equals(ageOfPerson)) {
                allByAge.add(person);
            }
        }
        if (!allByAge.isEmpty()) {
            return allByAge;
        }
        return null;
    }

    @Override
    public List<Person> getAllByAgeRange(Integer startAge, Integer lastAge) {
        if (startAge >= 0 && startAge <= lastAge) {
            List<Person> allByAgeRange = new ArrayList<>();
            for (Person person : people) {
                if (person.getAge() >= startAge && person.getAge() <= lastAge) {
                    allByAgeRange.add(person);
                }
            }
            if (!allByAgeRange.isEmpty()) {
                return allByAgeRange;
            }
        }
        return null;
    }

    @Override
    public void dropAll() {
        people = new ArrayList<>();
    }
}

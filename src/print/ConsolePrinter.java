package print;

import entity.Person;

import java.util.List;

public class ConsolePrinter implements IPrint{
    @Override
    public void showPeople(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

    @Override
    public void showPerson(Person person) {
        System.out.println(person.toString());
    }
}

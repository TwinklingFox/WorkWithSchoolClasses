package print;

import entity.Person;

import java.io.IOException;
import java.util.List;

public interface IPrint {
    void showPeople(List<Person> people) throws IOException;

    void showPerson(Person person) throws IOException;
}

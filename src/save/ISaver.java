package save;

import entity.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ISaver {
    void save(Person person) throws IOException;

    void drop(Person person) throws IOException;

    void dropByPosition(Integer position) throws IOException;

    List<Person> getAll() throws FileNotFoundException;

    List<Person> getAllByName(String nameOfPerson) throws FileNotFoundException;

    List<Person> getAllByAge(Integer ageOfPerson) throws FileNotFoundException;

    List<Person> getAllByAgeRange(Integer startAge, Integer lastAge) throws FileNotFoundException;

    void dropAll() throws IOException;
}

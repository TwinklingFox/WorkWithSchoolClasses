package print;

import entity.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilePrinter implements IPrint{
    private File newFileWithData = new File("newFileWithData.txt");
    @Override
    public void showPeople(List<Person> people) throws IOException {
        FileWriter fileWriter = new FileWriter(newFileWithData);
        for (Person person : people) {
            fileWriter.write(person.toString() + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    @Override
    public void showPerson(Person person) throws IOException {
        FileWriter fileWriter = new FileWriter(newFileWithData);
        fileWriter.write(person.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}

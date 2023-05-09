package save;

import entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSaver implements ISaver{
    private File fileWithData = new File("fileWithData.txt");
    private List<Person> peopleInPerson = new ArrayList<>();
    @Override
    public void save(Person person) throws IOException {
        peopleInPerson.add(person);
        writeInFile();
    }

    @Override
    public void drop(Person person) throws IOException {
        Scanner scanner = new Scanner(fileWithData);
        List<String> people = new ArrayList<>();
        while (scanner.hasNextLine()) {
            people.add(scanner.nextLine());
        }
        if (peopleInPerson.contains(person)) {
            peopleInPerson.remove(person);
        }
        if (people.contains(person.toString())) {
            people.remove(person.toString());
            writeInFile();
        } else {
            System.out.println("Ошибка! Такого человека нет в списке.");
        }
    }

    @Override
    public void dropByPosition(Integer position) throws IOException {
        position--;
        Scanner scanner = new Scanner(fileWithData);
        List<String> people = new ArrayList<>();
        while (scanner.hasNextLine()) {
            people.add(scanner.nextLine());
        }
        if (people.size() - 1 >= position && position >= 0) {
            String personData = people.get(position);
            for (Person person : peopleInPerson) {
                if (person.toString().equals(personData)) {
                    peopleInPerson.remove(person);
                    break;
                }
            }
            people.remove((int) position);
            writeInFile();
        } else {
            System.out.println("Ошибка! Человека под таким номером не существует.");
        }
    }

    @Override
    public List<Person> getAll() throws FileNotFoundException {
        return writeInList();
    }

    @Override
    public List<Person> getAllByName(String nameOfPerson) throws FileNotFoundException {
        List<Person> allByName = new ArrayList<>();
        List<Person> allPeople = writeInList();
        for (Person person : allPeople) {
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
    public List<Person> getAllByAge(Integer ageOfPerson) throws FileNotFoundException {
        List<Person> allByAge = new ArrayList<>();
        List<Person> allPeople = writeInList();
        for (Person person : allPeople) {
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
    public List<Person> getAllByAgeRange(Integer startAge, Integer lastAge) throws FileNotFoundException {
        if (startAge >= 0 && startAge <= lastAge) {
            List<Person> allByAgeRange = new ArrayList<>();
            List<Person> allPeople = writeInList();
            for (Person person : allPeople) {
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
    public void dropAll() throws IOException {
        FileWriter fileWriter = new FileWriter(fileWithData);
        if (!fileWithData.exists()) {
            fileWriter.write("");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    void writeInFile() throws IOException {
        FileWriter fileWriter = new FileWriter(fileWithData);
        if (!fileWithData.exists()) {
            for (Person person : peopleInPerson) {
                fileWriter.write(person.toString() + "\n");
            }
        } else {
            fileWithData = new File("fileWithData.txt");
            for (Person person : peopleInPerson) {
                fileWriter.write(person.toString() + "\n");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }

    List<Person> writeInList() throws FileNotFoundException {
        String name;
        String surname;
        Integer age;
        Classes classes = null;
        float averageMark;
        Integer salary;
        StatusOfWork statusOfWork = null;
        LevelOfEducation levelOfEducation = null;
        Integer buildings;

        peopleInPerson = new ArrayList<>();
        List<String> peopleInString = new ArrayList<>();
        Scanner scanner = new Scanner(fileWithData);
        while (scanner.hasNextLine()) {
            peopleInString.add(scanner.nextLine());
        }
        for (String str : peopleInString) {
            List<String> strings = List.of(str.split(","));
            if (strings.get(0).equals("Ученик")) {
                name = strings.get(1);
                surname = strings.get(2);
                age = Integer.parseInt(strings.get(3));
                if (strings.get(4).equals("1А")) {
                    classes = Classes.FIRSTA;
                } else if (strings.get(4).equals("1Б")) {
                    classes = Classes.FIRSTB;
                } else if (strings.get(4).equals("5А")) {
                    classes = Classes.FIFTHA;
                } else if (strings.get(4).equals("5Б")) {
                    classes = Classes.FIFTHB;
                } else if (strings.get(4).equals("10А")) {
                    classes = Classes.TENTHA;
                } else if (strings.get(4).equals("10Б")) {
                    classes = Classes.TENTHB;
                } else {
                    classes = Classes.UNKNOWN;
                }
                averageMark = Float.parseFloat(strings.get(5));
                peopleInPerson.add(new Pupil(name, surname, age, classes, averageMark));
            } else if (strings.get(0).equals("Школьный работник")) {
                name = strings.get(1);
                surname = strings.get(2);
                age = Integer.parseInt(strings.get(3));
                salary = Integer.parseInt(strings.get(4));
                if (strings.get(5).equals("Учитель")) {
                    statusOfWork = StatusOfWork.TEACHER;
                } else if (strings.get(5).equals("Директор")) {
                    statusOfWork = StatusOfWork.HEADMASTER;
                } else {
                    statusOfWork = StatusOfWork.UNKNOWN;
                }
                peopleInPerson.add(new SchoolWorker(name, surname, age, salary, statusOfWork));
            } else if (strings.get(0).equals("Учитель")) {
                name = strings.get(1);
                surname = strings.get(2);
                age = Integer.parseInt(strings.get(3));
                salary = Integer.parseInt(strings.get(4));
                if (strings.get(6).equals("1А")) {
                    classes = Classes.FIRSTA;
                } else if (strings.get(6).equals("1Б")) {
                    classes = Classes.FIRSTB;
                } else if (strings.get(6).equals("5А")) {
                    classes = Classes.FIFTHA;
                } else if (strings.get(6).equals("5Б")) {
                    classes = Classes.FIFTHB;
                } else if (strings.get(6).equals("10А")) {
                    classes = Classes.TENTHA;
                } else if (strings.get(6).equals("10Б")) {
                    classes = Classes.TENTHB;
                } else {
                    classes = Classes.UNKNOWN;
                }
                if (strings.get(7).equals("Начальная")) {
                    levelOfEducation = LevelOfEducation.PRIMARY;
                } else if (strings.get(7).equals("Средняя")) {
                    levelOfEducation = LevelOfEducation.SECONDARY;
                } else if (strings.get(7).equals("Старшая")) {
                    levelOfEducation = LevelOfEducation.HIGH;
                } else {
                    levelOfEducation = LevelOfEducation.UNKNOWN;
                }
                peopleInPerson.add(new Teacher(name, surname, age, salary, classes, levelOfEducation));
            } else if (strings.get(0).equals("Директор")) {
                name = strings.get(1);
                surname = strings.get(2);
                age = Integer.parseInt(strings.get(3));
                salary = Integer.parseInt(strings.get(4));
                buildings = Integer.parseInt(strings.get(6));
                peopleInPerson.add(new Headmaster(name, surname, age, salary, buildings));
            }
        }
        return peopleInPerson;
    }
}

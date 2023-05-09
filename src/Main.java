import entity.*;
import print.ConsolePrinter;
import print.FilePrinter;
import print.IPrint;
import save.FileSaver;
import save.ISaver;
import save.RuntimeSaver;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static ISaver iSaver;
    private static IPrint iPrint;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        boolean run = true;

        changeWayOfSave();
        changeWayOfPrint();

        while (run) {
            System.out.println("""
                    dfadsf
                    Что хотите сделать?
                    1)изменить способ сохранения
                    2)изменить способ вывода
                    3)добавить человека
                    4)удалить человека
                    5)удалить по номеру
                    6)вывести всех
                    7)вывести всех по имени
                    8)вывести всех по возрасту
                    9)вывести всех по диапазону возраста
                    10)очистить список
                    11)вывести всех в консоль/файл
                    12)вывести человека в консоль/файл по имени
                    0)выйти из программы""");
            int whatToDo = scan.nextInt();
            switch (whatToDo) {
                case 1:
                    changeWayOfSave();
                    System.out.println("Способ сохранения изменён.");
                    System.out.println();
                    break;
                case 2:
                    changeWayOfPrint();
                    System.out.println("Способ вывода изменён.");
                    System.out.println();
                    break;
                case 3:
                    addPerson();
                    System.out.println("Человек добавлен.");
                    System.out.println();
                    break;
                case 4:
                    dropPerson();
                    System.out.println("Человек удалён.");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Введите номер (отсчёт начинается с 1)");
                    int pos = scan.nextInt();
                    iSaver.dropByPosition(pos);
                    System.out.println("Человек удалён.");
                    System.out.println();
                    break;
                case 6:
                    for (Person person : iSaver.getAll()) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Введите имя");
                    scan.nextLine();
                    String name = scan.nextLine();
                    for (Person person : iSaver.getAllByName(name)) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Введите возраст");
                    int age = scan.nextInt();
                    for (Person person : iSaver.getAllByAge(age)) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Введите нижний предел (он будет включён в диапазон)");
                    int startAge = scan.nextInt();
                    System.out.println("Введите верхний предел (он будет включён в диапазон)");
                    int lastAge = scan.nextInt();
                    for (Person person : iSaver.getAllByAgeRange(startAge, lastAge)) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    break;
                case 10:
                    iSaver.dropAll();
                    System.out.println("Список очищен.");
                    System.out.println();
                    break;
                case 11:
                    iPrint.showPeople(iSaver.getAll());
                    System.out.println();
                    break;
                case 12:
                    System.out.println("Введите имя");
                    scan.nextLine();
                    String nameForShow = scan.nextLine();
                    for (Person person : iSaver.getAll()) {
                        if (person.getName().equals(nameForShow)) {
                            iPrint.showPerson(person);
                            break;
                        }
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Работа программы завершена.");
                    run = false;
                    break;
            }
        }
    }

    public static void changeWayOfSave() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите способ сохранения:\n1)локально\n2)файл");
        int wayOfWork = scan.nextInt();
        switch (wayOfWork) {
            case 1:
                iSaver = new RuntimeSaver();
                break;
            case 2:
                iSaver = new FileSaver();
                break;
        }
    }

    public static void changeWayOfPrint() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите способ вывода:\n1)локально\n2)файл");
        int wayOfWork = scan.nextInt();
        switch (wayOfWork) {
            case 1:
                iPrint = new ConsolePrinter();
                break;
            case 2:
                iPrint = new FilePrinter();
                break;
        }
    }

    public static void addPerson() throws IOException {
        Scanner scan = new Scanner(System.in);
        String name;
        String surname;
        Integer age;
        Classes classes = null;
        float averageMark;
        Integer salary;
        StatusOfWork statusOfWork;
        LevelOfEducation levelOfEducation = null;
        Integer buildings;

        System.out.println("Введите статус:\n1)Ученик\n2)Школьный работник\n3)Учитель\n4)Директор");
        int status = scan.nextInt();
        switch (status) {
            case 1:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Выберите класс (при наличии, иначе введите 0):\n1)1A\n2)1Б\n3)5А\n4)5Б\n5)10А\n6)10Б");
                int numOfClass = scan.nextInt();
                switch (numOfClass) {
                    case 1:
                        classes = Classes.FIRSTA;
                        break;
                    case 2:
                        classes = Classes.FIRSTB;
                        break;
                    case 3:
                        classes = Classes.FIFTHA;
                        break;
                    case 4:
                        classes = Classes.FIFTHB;
                        break;
                    case 5:
                        classes = Classes.TENTHA;
                        break;
                    case 6:
                        classes = Classes.TENTHB;
                        break;
                }
                System.out.println("Введите среднюю оценку (при наличии, иначе введите 0)");
                averageMark = (float) scan.nextInt();

                if (name.equals("") && surname.equals("")) {
                    iSaver.save(new Pupil());
                } else if (!name.equals("") && !surname.equals("") && classes == null && averageMark == 0.0f) {
                    iSaver.save(new Pupil(name, surname, age));
                } else if (!name.equals("") && !surname.equals("") && classes != null && averageMark != 0.0f) {
                    iSaver.save(new Pupil(name, surname, age, classes, averageMark));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
            case 2:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Введите зарплату (при наличии, иначе введите 0)");
                salary = scan.nextInt();
                System.out.println("Введите профессию (при наличии, иначе введите 0):\n1)Учитель\n2)Директор");
                int statusOfW = scan.nextInt();
                switch (statusOfW) {
                    case 1:
                        statusOfWork = StatusOfWork.TEACHER;
                        break;
                    case 2:
                        statusOfWork = StatusOfWork.HEADMASTER;
                        break;
                    default:
                        statusOfWork = StatusOfWork.UNKNOWN;
                        break;
                }

                if (name.equals("") && surname.equals("")) {
                    iSaver.save(new SchoolWorker());
                } else if (!name.equals("") && !surname.equals("") && salary == 0) {
                    iSaver.save(new SchoolWorker(name, surname, age));
                } else if (!name.equals("") && !surname.equals("")) {
                    iSaver.save(new SchoolWorker(name, surname, age, salary, statusOfWork));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
            case 3:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Выберите класс (при наличии, иначе введите 0):\n1)1A\n2)1Б\n3)5А\n4)5Б\n5)10А\n6)10Б");
                numOfClass = scan.nextInt();
                switch (numOfClass) {
                    case 1:
                        classes = Classes.FIRSTA;
                        break;
                    case 2:
                        classes = Classes.FIRSTB;
                        break;
                    case 3:
                        classes = Classes.FIFTHA;
                        break;
                    case 4:
                        classes = Classes.FIFTHB;
                        break;
                    case 5:
                        classes = Classes.TENTHA;
                        break;
                    case 6:
                        classes = Classes.TENTHB;
                        break;
                }
                System.out.println("Введите зарплату (при наличии, иначе введите 0)");
                salary = scan.nextInt();
                System.out.println("Введите, в какой школе преподаёт человек (при наличии, иначе введите 0):\n1)Начальная\n2)Средняя\n3)Старшая");
                int level = scan.nextInt();
                switch (level) {
                    case 1:
                        levelOfEducation = LevelOfEducation.PRIMARY;
                        break;
                    case 2:
                        levelOfEducation = LevelOfEducation.SECONDARY;
                        break;
                    case 3:
                        levelOfEducation = LevelOfEducation.HIGH;
                        break;
                }

                if (name.equals("") && surname.equals("")) {
                    iSaver.save(new Teacher());
                } else if (!name.equals("") && !surname.equals("") && salary == 0 && classes == null && levelOfEducation == null) {
                    iSaver.save(new Teacher(name, surname, age));
                } else if (!name.equals("") && !surname.equals("") && salary != 0 && classes != null && levelOfEducation != null) {
                    iSaver.save(new Teacher(name, surname, age, salary, classes, levelOfEducation));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
            case 4:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Введите зарплату (при наличии, иначе введите 0)");
                salary = scan.nextInt();
                System.out.println("Введите, сколько корпусов в подчинении (при наличии, иначе введите 0)");
                buildings = scan.nextInt();

                if (name.equals("") && surname.equals("")) {
                    iSaver.save(new Headmaster());
                } else if (!name.equals("") && !surname.equals("") && salary == 0 && buildings == 0) {
                    iSaver.save(new Headmaster(name, surname, age));
                } else if (!name.equals("") && !surname.equals("") && salary != 0 && buildings != 0) {
                    iSaver.save(new Headmaster(name, surname, age, salary, buildings));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
        }
    }

    public static void dropPerson() throws IOException {
        Scanner scan = new Scanner(System.in);
        String name;
        String surname;
        Integer age;
        Classes classes = null;
        float averageMark;
        Integer salary;
        StatusOfWork statusOfWork = null;
        LevelOfEducation levelOfEducation = null;
        Integer buildings;

        System.out.println("Введите статус:\n1)Ученик\n2)Школьный работник\n3)Учитель\n4)Директор");
        int status = scan.nextInt();
        switch (status) {
            case 1:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Выберите класс (при наличии, иначе введите 0):\n1)1A\n2)1Б\n3)5А\n4)5Б\n5)10А\n6)10Б");
                int numOfClass = scan.nextInt();
                switch (numOfClass) {
                    case 1:
                        classes = Classes.FIRSTA;
                        break;
                    case 2:
                        classes = Classes.FIRSTB;
                        break;
                    case 3:
                        classes = Classes.FIFTHA;
                        break;
                    case 4:
                        classes = Classes.FIFTHB;
                        break;
                    case 5:
                        classes = Classes.TENTHA;
                        break;
                    case 6:
                        classes = Classes.TENTHB;
                        break;
                }
                System.out.println("Введите среднюю оценку (при наличии, иначе введите 0)");
                averageMark = scan.nextFloat();

                if (name.equals("") && surname.equals("")) {
                    iSaver.drop(new Pupil());
                } else if (!name.equals("") && !surname.equals("") && classes == null && averageMark == 0.0f) {
                    iSaver.drop(new Pupil(name, surname, age));
                } else if (!name.equals("") && !surname.equals("") && classes != null && averageMark != 0.0f) {
                    iSaver.drop(new Pupil(name, surname, age, classes, averageMark));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
            case 2:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Введите зарплату (при наличии, иначе введите 0)");
                salary = scan.nextInt();
                System.out.println("Введите профессию (при наличии, иначе введите 0):\n1)Учитель\n2)Директор");
                int statusOfW = scan.nextInt();
                switch (statusOfW) {
                    case 1:
                        statusOfWork = StatusOfWork.TEACHER;
                        break;
                    case 2:
                        statusOfWork = StatusOfWork.HEADMASTER;
                        break;
                }

                if (name.equals("") && surname.equals("")) {
                    iSaver.drop(new SchoolWorker());
                } else if (!name.equals("") && !surname.equals("") && salary == 0 && statusOfWork == null) {
                    iSaver.drop(new SchoolWorker(name, surname, age));
                } else if (!name.equals("") && !surname.equals("") && salary != 0 && statusOfWork != null) {
                    iSaver.drop(new SchoolWorker(name, surname, age, salary, statusOfWork));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
            case 3:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Выберите класс (при наличии, иначе введите 0):\n1)1A\n2)1Б\n3)5А\n4)5Б\n5)10А\n6)10Б");
                numOfClass = scan.nextInt();
                switch (numOfClass) {
                    case 1:
                        classes = Classes.FIRSTA;
                        break;
                    case 2:
                        classes = Classes.FIRSTB;
                        break;
                    case 3:
                        classes = Classes.FIFTHA;
                        break;
                    case 4:
                        classes = Classes.FIFTHB;
                        break;
                    case 5:
                        classes = Classes.TENTHA;
                        break;
                    case 6:
                        classes = Classes.TENTHB;
                        break;
                }
                System.out.println("Введите зарплату (при наличии, иначе введите 0)");
                salary = scan.nextInt();
                System.out.println("Введите профессию (при наличии, иначе введите 0):\n1)Учитель\n2)Директор");
                statusOfW = scan.nextInt();
                switch (statusOfW) {
                    case 1:
                        statusOfWork = StatusOfWork.TEACHER;
                        break;
                    case 2:
                        statusOfWork = StatusOfWork.HEADMASTER;
                        break;
                }
                System.out.println("Введите, в какой школе преподаёт человек (при наличии, иначе введите 0):\n1)Начальная\n2)Средняя\n3)Старшая");
                int level = scan.nextInt();
                switch (level) {
                    case 1:
                        levelOfEducation = LevelOfEducation.PRIMARY;
                        break;
                    case 2:
                        levelOfEducation = LevelOfEducation.SECONDARY;
                        break;
                    case 3:
                        levelOfEducation = LevelOfEducation.HIGH;
                        break;
                }

                if (name.equals("") && surname.equals("")) {
                    iSaver.drop(new Teacher());
                } else if (!name.equals("") && !surname.equals("") && salary == 0 && statusOfWork == null && classes == null && levelOfEducation == null) {
                    iSaver.drop(new Teacher(name, surname, age));
                } else if (!name.equals("") && !surname.equals("") && salary != 0 && statusOfWork != null && classes != null && levelOfEducation != null) {
                    iSaver.drop(new Teacher(name, surname, age, salary, classes, levelOfEducation));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
            case 4:
                System.out.println("Введите имя (при наличии, иначе нажмите Enter)");
                scan.nextLine();
                name = scan.nextLine();
                System.out.println("Введите фамилию (при наличии, иначе нажмите Enter)");
                surname = scan.nextLine();
                System.out.println("Введите возраст (при наличии, иначе введите 0)");
                age = scan.nextInt();
                System.out.println("Введите зарплату (при наличии, иначе введите 0)");
                salary = scan.nextInt();
                System.out.println("Введите, сколько корпусов в подчинении (при наличии, иначе введите 0)");
                buildings = scan.nextInt();

                if (name.equals("") && surname.equals("")) {
                    iSaver.drop(new Headmaster());
                } else if (!name.equals("") && !surname.equals("") && salary == 0 && buildings == 0) {
                    iSaver.drop(new Headmaster(name, surname, age));
                } else if (!name.equals("") && !surname.equals("") && salary != 0 && buildings != 0) {
                    iSaver.drop(new Headmaster(name, surname, age, salary, buildings));
                } else {
                    System.out.println("Ошибка! Вы ввели что-то не так.");
                }
                break;
        }
    }
}
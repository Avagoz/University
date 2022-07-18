package Project;

import java.util.*;
import java.util.stream.Collectors;

import Project.base.Address;
import Project.base.People;
import Project.model.Group;
import Project.model.Methodist;
import Project.model.Student;
import Project.model.Teacher;
import Project.util.*;

public class Main {

    public static void main(String[] args) {
        List<People> people = new ArrayList<>();
        //Comporator People---------------------------------------------
        NameComporator nameComporator = new NameComporator();
        SurnameComporator surnameComporator = new SurnameComporator();
        AgeComporator ageComporator = new AgeComporator();
        GenderComporator genderComporator = new GenderComporator();
        //Comporator Payday---------------------------------------------
        PaydayComporator paydayComporator = new PaydayComporator();
        //Comporator Group----------------------------------------------
        GroupComporator groupComporator = new GroupComporator();
        YearComporator yearComporator = new YearComporator();
        StartComporator startComporator = new StartComporator();
        EndComporator endComporator = new EndComporator();
        //--------------------------------------------------------------
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group(0, 0, 0, 0, 0));
        groups.add(new Group(101, 2000, 2006, 3, 2));
        groups.add(new Group(202, 2001, 2007, 3, 2));
        groups.get(0).getStud().add(new Student("Denis", "Ivanov", "M", 20));
        groups.get(1).getStud().add(new Student("Ivan", "Ivanov", "M", 19));
        groups.get(1).getStud().add(new Student("Max", "Ivanov", "M", 19));
        groups.get(2).getStud().add(new Student("Sveta", "Ivanov", "F", 19));
        groups.get(2).getStud().add(new Student("Olya", "Ivanov", "F", 19));
        List<Methodist> met = new ArrayList<>();
        met.add(new Methodist(" ", " ", " ", 0, 0, new Address("...", "...", "...", 0)));

        met.get(0).setTeachers(new ArrayList<>());
        met.get(0).getTeachers().add(new Teacher("Olya", "Teach1", "F", 59, 5));
        met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));
        met.get(0).getTeachers().add(new Teacher("Galya", "Teach2", "F", 19, 50));
        met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));
        met.get(0).getTeachers().add(new Teacher("Albert", "Teach3", "M", 68, 15));
        met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));

        ToMethodist<Methodist, Teacher> metConvert = (teacher) -> new Methodist(teacher.getName(), teacher.getSurname(),
                teacher.getGender(), teacher.getAge(), teacher.getPayday() * 2, teacher.getAddress());
        Scanner scan = new Scanner(System.in);
        //--------------------------------------------------------------------------------------------------------------
        System.out.println("\n=============================\n" +
                "Welcome to project Univercity\n" +
                "=============================");
        labelProject:

        while (true) {
            System.out.println("""
                    ------------
                    Главное меню\s
                    ------------
                    Для того чтобы отредактировать список групп, введите Group
                    Для того чтобы отредактировать список студентов, введите Students
                    Для того чтобы отредактировать список Методистов и учителей, которые за ними закреплены, введите Personal
                    Для того чтобы отобразить информацию, введите Display
                    Для того, чтобы выйти из программы, введите Exit""");


            String otvetS = scan.nextLine();
            switch (otvetS) {
                case "Group":
                    //---------------------------------------------------------------------------Остновная информация о Группе
                    while (true) {
                        System.out.println("\nДля того, чтообы удалить группу, введите Delete\n" +
                                "Для того, чтобы добавить группу, введите Add\n" +
                                "Для того, чтобы выйти в главное меню, введите Back");
                        otvetS = scan.nextLine();
                        //-------------------------------------------------------------------------Удаление Группы
                        if ("Delete".equals(otvetS)) {
                            System.out.printf("Какую группу удалить? [1-%d]", groups.size() - 1);
                            int d = Integer.parseInt(scan.nextLine());
                            if (d > groups.size() - 1 || d < 0) {
                                System.out.println("Invalid number, Try Again");

                            } else if (d == 0) {
                                groups.add(0, new Group(0, 0, 0, 0, 0));
                                groups.get(0).getStud().addAll(groups.get(1).getStud());
                                groups.remove(1);

                            } else {
                                groups.get(0).getStud().addAll(groups.get(d).getStud());
                                groups.remove(d);
                                groups.forEach(System.out::println);
                            }
                            //-----------------------------------------------------------------------Добавление Учителя
                        } else if ("Add".equals(otvetS)) {

                            groups.add(new Group(groups.get(groups.size() - 1).getGroup(),
                                    groups.get(groups.size() - 1).getYearStart(),
                                    groups.get(groups.size() - 1).getYearEnd(),
                                    groups.get(groups.size() - 1).getYear(),
                                    groups.get(groups.size() - 1).getRazmer()));

                            System.out.println("""
                                    ==================
                                    Group Information
                                    ==================\s""");
                            System.out.print("Group number: ");                                           //номер группы
                            groups.get(groups.size() - 1).setGroup(Integer.parseInt(scan.nextLine()));
                            System.out.println("Дата поступления: ");
                            groups.get(groups.size() - 1).setYearStart(Integer.parseInt(scan.nextLine()));
                            System.out.println("Даата выпуска: ");
                            groups.get(groups.size() - 1).setYearEnd(Integer.parseInt(scan.nextLine()));
                            System.out.print("Year: ");                                                   // курс
                            groups.get(groups.size() - 1).setYear(Integer.parseInt(scan.nextLine()));
                            System.out.print("Number of students: ");                                     //Количество студентов группе
                            groups.get(groups.size() - 1).setRazmer(Integer.parseInt(scan.nextLine()));
                            groups.forEach(System.out::println);
                            //--------------------------------------------------------------------------------------

                            //-----------------------------------------------------------------------------------------Пропуск Группа
                        } else if ("Back".equals(otvetS)) {
                            break;
                        }
                    }
                    break;
                case "Students":
                    student:
                    while (true) {
                        System.out.printf("Выберите группу в которой будем редактировать список студентов [0-%d]", groups.size() - 1);
                        int z = Integer.parseInt(scan.nextLine());
                        if (z > groups.size() - 1 || z < 0) {
                            System.out.println("Invalid number, Try Again");
                        }
                        label:
                        while (true) {
                            System.out.println();
                            System.out.println("Для того, чтобы добавить студента, введите Add\n" +
                                    "Для того, чтобы исключить студета, введите Delete\n" +
                                    "Для того, чтобы вернуться в главное меню, введите Back");
                            otvetS = scan.nextLine();
                            //-------------------------------------------------------------------------удаление ученика из группы
                            switch (otvetS) {
                                case "Delete":
                                    System.out.println("Какого студента исключить?");
                                    int d = Integer.parseInt(scan.nextLine());
                                    if (d >= groups.get(z).getStud().size()) {
                                        System.out.println("Invalid number, Try Again");
                                    } else {
                                        groups.get(z).deleteStud(d);


                                        groups.get(z).getStud().forEach(System.out::println);


                                        if (groups.get(z).getStud().size() > 1 && groups.get(z).getStud().size() < 5) {
                                            System.out.println("В группе " + groups.get(z).getStud().size() + " Ученика");
                                        } else if (groups.get(z).getStud().size() == 1) {
                                            System.out.println("В группе " + groups.get(z).getStud().size() + " Ученик");
                                        } else {
                                            System.out.println("В группе " + groups.get(z).getStud().size() + " Учеников");
                                        }

                                    }
                                    //-----------------------------------------------------------------------Добавление ученика в группу
                                    break;
                                case "Add":
                                    if (groups.get(z).getStud().size() == 0) {                                //Еcли в массиве не остается учеников,
                                        groups.get(z).getStud().add(new Student("...", "...", "...", 0));            //то условие создает новый массив
                                        groups.get(z).getStud().get(groups.get(z).getStud().size() - 1)
                                                .setAddress(new Address("...", "...", "...", 0));
                                        groups.get(z).addStud();
                                        groups.get(z).deleteStud(0);
                                    } else {
                                        groups.get(z).addStud();
                                    }
                                    System.out.println("""


                                            Student's information
                                            ---------------------""");
                                    System.out.print("Name: ");
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).setName(scan.nextLine());
                                    System.out.print("Surname: ");
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).setSurname(scan.nextLine());
                                    System.out.print("Age: ");
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).setAge(Integer.parseInt(scan.nextLine()));
                                    System.out.println("\nEnter Student Address");
                                    System.out.print("City: ");
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).getAddress().setCity(scan.nextLine());
                                    System.out.print("Street: ");
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).getAddress().setStreet(scan.nextLine());
                                    System.out.print("Home #: ");
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).getAddress().setHome(scan.nextLine());
                                    System.out.print("Apartments #: ");
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).getAddress().setApt(Integer.parseInt(scan.nextLine()));

                                    groups.get(z).getStud().forEach(System.out::println);

                                    if (groups.get(z).getStud().size() > 1 && groups.get(z).getStud().size() < 5) {
                                        System.out.println("В группе " + groups.get(z).getStud().size() + " Ученика");
                                    } else if (groups.get(z).getStud().size() == 1) {
                                        System.out.println("В группе " + groups.get(z).getStud().size() + " Ученик");
                                    } else {
                                        System.out.println("В группе " + groups.get(z).getStud().size() + " Учеников");
                                    }
                                    //-----------------------------------------------------------------------------------------Пропуск студенты
                                    break;
                                case "Back":
                                    break label;
                            }
                        }
                        break student;
                    }
                    break;
                //----------------------------------------------------------------------------------------------------------------------------------------------------------------
                case "Personal":
                    //---------------------------------------------------------------------------Остновная информация о Учителе
                    labelPersonal:
                    while (true) {
                        System.out.println("\nДля того, чтобы обновить список учителей, введите Teacher\n" +
                                "Для того, чтобы обновить списоок методистов, введите Methodist\n" +
                                "Для того, чтобы вернуться в главное меню, введите Back");
                        otvetS = scan.nextLine();
                        switch (otvetS) {
                            case "Teacher":
                                label1:
                                while (true) {

                                    System.out.println("\nДля того, чтобы уволить учителя, введите Delete\n" +
                                            "Для того, чтобы добавить учителя, введите Add\n" +
                                            "Для того, чтобы вернуться назад, введите Back");
                                    otvetS = scan.nextLine();
                                    //-------------------------------------------------------------------------Увольнение Учителя
                                    switch (otvetS) {
                                        case "Delete":
                                            System.out.printf("Выбирете Методиста за которым закреплен педагог? [0-%d]", (met.size() - 1));
                                            int k = Integer.parseInt(scan.nextLine());
                                            if (k > met.size() - 1 || k < 0) {
                                                System.out.println("Invalid number, Try Again");
                                                break;
                                            }
                                            System.out.printf("Какого учителя уволить? [0-]", (met.get(k).getTeachers().size() - 1));
                                            int d = Integer.parseInt(scan.nextLine());
                                            if (d > met.get(k).getTeachers().size() - 1 || d < 0) {
                                                System.out.println("Invalid number, Try Again");
                                                break;
                                            } else {
                                                met.get(met.size() - 1).deleteTeach(d);
                                                met.get(met.size() - 1).getTeachers().forEach(System.out::println);
                                            }
                                            //-----------------------------------------------------------------------Добавление Учителя
                                            break;
                                        case "Add":
                                            System.out.printf("Выберите Методиста за которым будет закреплен педагог [0-%d]", (met.size() - 1));
                                            k = Integer.parseInt(scan.nextLine());
                                            if (k > met.size() - 1 || k < 0) {
                                                System.out.println("Invalid number, Try Again");
                                                break;
                                            }
                                            if (met.get(k).getTeachers().size() == 0) {                                //Еcли в массиве не остается Учителя,
                                                met.get(k).getTeachers().add(new Teacher("...", "...", "M", 0, 0));   //то условие создает новый массив
                                                met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));
                                                met.get(k).addTeach();
                                                met.get(k).deleteTeach(0);
                                            } else {
                                                met.get(k).addTeach();
                                            }
                                            System.out.println("""


                                                    Teachers information
                                                    ---------------------""");
                                            System.out.print("Name: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).setName(scan.nextLine());
                                            System.out.print("Surname: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).setSurname(scan.nextLine());
                                            System.out.print("Gender: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).setGender(scan.nextLine());
                                            System.out.print("Age: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).setAge(Integer.parseInt(scan.nextLine()));

                                            label2:
                                            while (true) {

                                                System.out.println("Redact lessons? Yes/No");
                                                String otvetL = scan.nextLine();

                                                switch (otvetL) {
                                                    case "Yes":
                                                        System.out.print("Количество часов: ");            //колличество занятий, отсюда будет

                                                        int less = Integer.parseInt(scan.nextLine());
                                                        met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).setPayday(less);            // расчитываться Зарплата преподователя

                                                        break;
                                                    case "No":
                                                        break label2;
                                                }
                                            }
                                            System.out.println("\nEnter Teacher Address");
                                            System.out.print("City: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).getAddress().setCity(scan.nextLine());
                                            System.out.print("Street: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).getAddress().setStreet(scan.nextLine());
                                            System.out.print("Home #: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).getAddress().setHome(scan.nextLine());
                                            System.out.print("Apartments #: ");
                                            met.get(k).getTeachers().get(met.get(k).getTeachers().size() - 1).getAddress().setApt(Integer.parseInt(scan.nextLine()));
                                            met.get(k).getTeachers().forEach(System.out::println);


                                            //-----------------------------------------------------------------------------------------Пропуск
                                            break;
                                        case "Back":
                                            break label1;
                                    }
                                }
                                break;
                            case "Methodist":
                                metodist:
                                while (true) {
                                    System.out.println("\nДля того, чтобы уволить Методиста, введите Delete\n" +
                                            "Для того, чтобы повысить педагога в методисты, введите Add\n" +
                                            "Для того, чтобы вернуться, введите Back");
                                    otvetS = scan.nextLine();
                                    //-------------------------------------------------------------------------Увольнение Учителя
                                    switch (otvetS) {
                                        case "Delete":
                                            System.out.println("Какого Методиста уволить?");
                                            int d = Integer.parseInt(scan.nextLine());
                                            if (d == 0) {
                                                met.add(0, new Methodist(" ", " ", " ", 0, 0, new Address("...", "...", "...", 0)));
                                                met.get(0).getTeachers().addAll(met.get(1).getTeachers());
                                                met.remove(1);
                                            } else if (d > met.size() - 1 || d < 0) {
                                                System.out.println("Invalid number, Try Again");
                                            } else {
                                                met.get(0).getTeachers().addAll(met.get(d).getTeachers());
                                                met.remove(d);
                                                met.forEach(System.out::println);
                                            }

                                            //-----------------------------------------------------------------------Добавление Методиста
                                            break;
                                        case "Add":
                                            if (met.get(met.size() - 1).getTeachers().size() == 0) {                                //Еcли в массиве не остается Учителя,
                                                System.out.println("Доступных учителей для повышения нету");
                                            }
                                            System.out.printf("Выбирете методиста, у которого хотите забрать педагога [0-%d]", (met.size() - 1));
                                            int k = Integer.parseInt(scan.nextLine());
                                            if (k > met.size() - 1 || k < 0) {
                                                System.out.println("Invalid number, Try Again");
                                                break;
                                            }
                                            if (met.get(k).getTeachers().size() == 0) {                                //Еcли в массиве не остается Учителя,
                                                System.out.println("Доступных учителей для повышения нету");
                                            }
                                            System.out.printf("Какого Педагога перевести в методисты? [0-%d]", (met.get(k).getTeachers().size() - 1));
                                            int r = Integer.parseInt(scan.nextLine());
                                            if (r > met.get(k).getTeachers().size() - 1 || k < 0) {
                                                System.out.println("Invalid number, Try Again");
                                                break;
                                            }
                                            met.add(metConvert.convert(met.get(k).getTeachers().get(r)));
                                            met.get(k).getTeachers().remove(r);

                                            met.forEach(System.out::println);
                                            //-----------------------------------------------------------------------------------------Пропуск
                                            break;
                                        case "Back":
                                            break metodist;
                                    }
                                }
                                break;
                            case "Back":
                                break labelPersonal;
                        }
                    }
                    break;
                case "Display":
                    //-------------------------------------------------------------------------------------------------Результат
                    display:
                    while (true) {
                        System.out.println("Для того, чтобы отобразить информацию, введите Info\n" +
                                "Для того, чтобы отсортировать информацию, введите Sort\n" +
                                "Для того, чтобы выйти в главное меню, введите Back");
                        otvetS = scan.nextLine();

                        switch (otvetS) {
                            case "Info":
                                groups.forEach(System.out::println);
                                met.forEach(System.out::println);
                                break;
                            case "Sort":
                                System.out.println("Для того, чтобы отсортировать персонал, введите Personal\n" +
                                        "Для того, чтобы отсортироваать студентов в группах, введите Students\n" +
                                        "Для того, чтобы отсортировать группу, введите Group");
                                otvetS = scan.nextLine();
                                switch (otvetS) {


                                    case "Personal" -> {

                                        System.out.println("Для того, чтобы отсортироваать по имени, введите Name\n" +
                                                "Для того, чтобы отсортировать по фамилии, введите Surname\n" +
                                                "Для того, чтобы отсортировать по возраст, введите Age\n" +
                                                "Чтобы отсортировать по полу, введите Gender\n" +
                                                "Для того, чтобы отсортировать по зарплате, введите Payday\n" +
                                                "Для того, чтобы отобразить педагогов пенсионного возраста, введите Pension\n" +
                                                "Для того, чтобы отобразить педагогов, зарплата которых выше определенной суммы, введите SizePD\n");
                                        otvetS = scan.nextLine();
                                        switch (otvetS) {
                                            case "Name" -> {
                                                for (int i = 0; i < met.size(); i++) {
                                                    met.get(i).getTeachers().sort(nameComporator);
                                                }
                                                met.sort(nameComporator);
                                                System.out.println(met);

                                            }
                                            case "Surname" -> {
                                                for (int i = 0; i < met.size(); i++) {
                                                    met.get(i).getTeachers().sort(surnameComporator);
                                                }
                                                met.sort(surnameComporator);
                                                System.out.println(met);

                                            }
                                            case "Age" -> {
                                                for (int i = 0; i < met.size(); i++) {
                                                    met.get(i).getTeachers().sort(ageComporator);

                                                }
                                                met.sort(ageComporator);
                                                System.out.println(met);

                                            }
                                            case "Gender" -> {
                                                for (int i = 0; i < met.size(); i++) {
                                                    met.get(i).getTeachers().sort(genderComporator);
                                                }
                                                met.sort(genderComporator);
                                                System.out.println(met);

                                            }
                                            case "Payday" -> {
                                                for (int i = 0; i < met.size(); i++) {
                                                    met.get(i).getTeachers().sort(nameComporator);
                                                    met.get(i).getTeachers().sort(paydayComporator);
                                                }
                                                met.sort(nameComporator);
                                                met.sort(paydayComporator);
                                                System.out.println(met);

                                            }
                                            case "Pension" -> {
                                                List<Teacher> cashTeach = new ArrayList<>();
                                                List<Teacher> cashTeach1;
                                                for (int i = 0; i < met.size(); i++) {
                                                    cashTeach.addAll(met.get(i).getTeachers());
                                                }
                                                System.out.println("\nУчителя на пенсии");
                                                cashTeach1 = cashTeach.stream().filter((x) -> (x.getGender().equals("M") && x.getAge() > 62) || (x.getGender().equals("F") && x.getAge() > 57)).collect(Collectors.toList());//age
                                                cashTeach1.forEach(System.out::println);
                                                cashTeach.removeAll(cashTeach);
                                                cashTeach.removeAll(cashTeach1);

                                            }
                                            case "SizePD" -> {
                                                System.out.println("Введите размер зарплаты, по которой будут отсортированы педагоги");
                                                int pd = Integer.parseInt(scan.nextLine());
                                                System.out.println("\nУчителя, чья зарплата выше " + pd + " BYN");
                                                List<Teacher> cashTeach = new ArrayList<>();
                                                List<Teacher> cashTeach1;
                                                for (int i = 0; i < met.size(); i++) {
                                                    cashTeach.addAll(met.get(i).getTeachers());
                                                }
                                                cashTeach1 = cashTeach.stream().filter((x) -> x.getPayday() > pd).collect(Collectors.toList());//payday
                                                cashTeach1.forEach(System.out::println);
                                                cashTeach.removeAll(cashTeach);
                                                cashTeach.removeAll(cashTeach1);

                                            }
                                        }
                                    }
                                    case "Students" -> {
                                        sortS:
                                        System.out.println("Для того, чтобы отсортироваать по имени, введите Name\n" +
                                                "Для того, чтобы отсортировать по фамилии, введите Surname\n" +
                                                "Для того, чтобы отсортировать по возраст, введите Age\n" +
                                                "Для того, чтобы отсортировать по полу, введите Gender\n");
                                        otvetS = scan.nextLine();
                                        switch (otvetS) {
                                            case "Name" -> {
                                                for (int i = 0; i < groups.size(); i++) {
                                                    groups.get(i).getStud().sort(nameComporator);
                                                    System.out.println(groups);
                                                }

                                            }
                                            case "Surname" -> {
                                                for (int i = 0; i < groups.size(); i++) {
                                                    groups.get(i).getStud().sort(surnameComporator);
                                                    System.out.println(groups.get(i).getStud());
                                                }

                                            }
                                            case "Age" -> {
                                                for (int i = 0; i < groups.size(); i++) {
                                                    groups.get(i).getStud().sort(ageComporator);
                                                    System.out.println(groups.get(i).getStud());
                                                }

                                            }
                                            case "Gender" -> {
                                                for (int i = 0; i < groups.size(); i++) {
                                                    groups.get(i).getStud().sort(genderComporator);
                                                    System.out.println(groups.get(i).getStud());
                                                }

                                            }
                                        }
                                    }
                                    case "Group" -> {
                                        System.out.println("Для того, чтобы отсортироваать по номеру группы, введите Group\n" +
                                                "Для того, чтобы отсортировать по курсу, введите Year\n" +
                                                "Для того, чтобы отсортировать по году поступления, введите Start\n" +
                                                "Для того, чтобы отсортировать по году выпуска, введите End\n" +
                                                "Для того, чтобы отобразить список групп в заданном диапазоне года выпуска, введите Grad\n");
                                        String otvetL = scan.nextLine();
                                        switch (otvetL) {
                                            case "Group" -> {
                                                groups.sort(groupComporator);
                                                System.out.println(groups);

                                            }
                                            case "Year" -> {
                                                groups.sort(yearComporator);
                                                System.out.println(groups);

                                            }
                                            case "Start" -> {
                                                groups.sort(startComporator);
                                                System.out.println(groups);

                                            }
                                            case "End" -> {
                                                groups.sort(endComporator);
                                                System.out.println(groups);

                                            }
                                            case "Grad" -> {
                                                System.out.println("Введите диапазон даты выпуска");
                                                int start = Integer.parseInt(scan.nextLine());
                                                int end = Integer.parseInt(scan.nextLine());
                                                System.out.println("Список групп в заданном диапазоне");
                                                List<Group> cashGroup = new ArrayList<>();
                                                cashGroup = groups.stream().filter(x -> x.getYearEnd() < end + 1 && x.getYearEnd() > start - 1).collect(Collectors.toList());
                                                cashGroup.forEach(System.out::println);

                                            }
                                        }
                                    }
                                }
                                break;

                            case "Back":
                                break display;
                        }
                    }
                    break;
                case "Exit":
                    System.out.println("Завершение работы");
                    break labelProject;
            }
        }
        scan.close();
    }
}




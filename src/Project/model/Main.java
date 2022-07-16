package Project.model;

import java.util.*;
import java.util.stream.Collectors;

import Project.util.*;

public class Main {

    public static void main(String[] args) {
        List<People>people=new ArrayList<>();
        NameComporator nameComporator=new NameComporator();
        SurnameComporator surnameComporator = new SurnameComporator();
        AgeComporator ageComporator = new AgeComporator();
        GenderComporator genderComporator = new GenderComporator();
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group(101,2000,2006,3,2));
        groups.add(new Group(202,2001,2007,3,2));
        groups.get(0).getStud().add(new Student("Ivan", "Ivanov", "M", 19));

        groups.get(0).getStud().add(new Student("Max", "Ivanov", "M", 19));
        groups.get(1).getStud().add(new Student("Sveta", "Ivanov", "F", 19));
        groups.get(1).getStud().add(new Student("Olya", "Ivanov", "F", 19));
        List<Metodist> met = new ArrayList<>();
        met.add(new Metodist());
        met.get(met.size() - 1).setTeachers(new ArrayList<>());
        met.get(0).getTeachers().add(new Teacher("Olya", "Teach1", "F", 59,5));
        met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));
        met.get(0).getTeachers().add(new Teacher("Galya", "Teach2", "F", 19,50));
        met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));
        met.get(0).getTeachers().add(new Teacher("Albert", "Teach3", "M", 68,15));
        met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));

        ToMetodist<Metodist, Teacher> metConvert = (teacher) -> new Metodist(teacher.getName(), teacher.getSurname(),
                teacher.getGender(), teacher.getAge(), teacher.getPayday(), teacher.getAddress());
        Scanner scan = new Scanner(System.in);
        //--------------------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------Остновная информация о Группе
        while (true) {
            System.out.println();
            System.out.println("Redact Group List? Delete/Add/Skip");
            String otvetS = scan.nextLine();
            //-------------------------------------------------------------------------Удаление Группы
            if ("Delete".equals(otvetS)) {
                System.out.println("Какую группу удалить?");
                int d = Integer.parseInt(scan.nextLine());
                if (d >= groups.size()) {
                    System.out.println("Invalid number, Try Again");
                } else {
                    groups.remove(d);


                    groups.forEach(System.out::println);

                }
                //-----------------------------------------------------------------------Добавление Учителя
            } else if ("Add".equals(otvetS)) {
                if (groups.size() == 0) {                                                                    //Еcли в массиве не остается Учителя,
                    groups.add(new Group(0, 0, 0, 0, 0));                   //то условие создает новый массив

                    groups.add(new Group(groups.get(groups.size() - 1).getGroup(),
                            groups.get(groups.size() - 1).getYearStart(),
                            groups.get(groups.size() - 1).getYearEnd(),
                            groups.get(groups.size() - 1).getYear(),
                            groups.get(groups.size() - 1).getRazmer()));
                    groups.remove(0);
                } else {
                    groups.add(new Group(groups.get(groups.size() - 1).getGroup(),
                            groups.get(groups.size() - 1).getYearStart(),
                            groups.get(groups.size() - 1).getYearEnd(),
                            groups.get(groups.size() - 1).getYear(),
                            groups.get(groups.size() - 1).getRazmer()));


                }

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
                for (int z = 0; z < groups.size(); z++) {
                    label:
                    while (true) {
                        System.out.println();
                        System.out.println("Redact Student List? Delete/Add/Skip");
                        otvetS = scan.nextLine();
                        //-------------------------------------------------------------------------удаление ученика из группы
                        switch (otvetS) {
                            case "Delete":
                                System.out.println("Какого студента удалить?");
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
                                    groups.get(z).getStud().get(groups.get(z).getStud().size() - 1).setAddress(new Address("...", "...", "...", 0));
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
                            case "Skip":
                                break label;
                        }
                    }
                }
                //-----------------------------------------------------------------------------------------Пропуск Группа
            } else if ("Skip".equals(otvetS)) {
                break;
            }
        }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------
        if (groups.size() == 0) {
            System.out.println("Нету зарегистрированных групп");
        } else {
            groups.forEach(System.out::println);

        }
        if (met.get(met.size() - 1).getTeachers().size() == 0) {
            System.out.println("Учителей нет");
        } else {
            met.get(met.size() - 1).getTeachers().forEach(System.out::println);
        }
        //---------------------------------------------------------------------------Остновная информация о Учителе
        labelPersonal:
        while (true) {
            System.out.println();
            System.out.println("Redact Personal List? Yes/No");
            String otvetS = scan.nextLine();
            switch (otvetS) {
                case "Yes":

                    label1:
                    while (true) {
                        System.out.println();
                        System.out.println("Redact Teacher List? Delete/Add/Skip");
                        otvetS = scan.nextLine();

                        //-------------------------------------------------------------------------Увольнение Учителя
                        switch (otvetS) {
                            case "Delete":
                                System.out.println("Какого Учителя уволить?");
                                int d = Integer.parseInt(scan.nextLine());
                                if (d >= met.get(met.size() - 1).getTeachers().size()) {
                                    System.out.println("Invalid number, Try Again");
                                } else {
                                    met.get(met.size() - 1).deleteTeach(d);
                                    met.get(met.size() - 1).getTeachers().forEach(System.out::println);
                                }

                                //-----------------------------------------------------------------------Добавление Учителя
                                break;
                            case "Add":
                                if (met.get(met.size() - 1).getTeachers().size() == 0) {                                //Еcли в массиве не остается Учителя,
                                    met.get(met.size() - 1).getTeachers().add(new Teacher("...", "...", "M", 0, 0));   //то условие создает новый массив

                                    met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAddress(new Address("...", "...", "...", 0));
                                    met.get(met.size() - 1).addTeach();

                                    met.get(met.size() - 1).deleteTeach(0);
                                } else {
                                    met.get(met.size() - 1).addTeach();
                                }
                                System.out.println("""


                                        Teachers information
                                        ---------------------""");
                                System.out.print("Name: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setName(scan.nextLine());
                                System.out.print("Surname: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setSurname(scan.nextLine());
                                System.out.println("Gender: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setGender(scan.nextLine());
                                System.out.print("Age: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setAge(Integer.parseInt(scan.nextLine()));

                                label2:
                                while (true) {

                                    System.out.println("Redact lessons? Yes/No");
                                    String otvetL = scan.nextLine();

                                    switch (otvetL) {
                                        case "Yes":
                                            System.out.print("Number of lessons: ");            //колличество занятий, отсюда будет

                                            int less = Integer.parseInt(scan.nextLine());
                                            met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).setPayday(less);            // расчитываться Зарплата преподователя

                                            break;
                                        case "No":
                                            break label2;
                                    }
                                }
                                System.out.println("\nEnter Teacher Address");
                                System.out.print("City: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).getAddress().setCity(scan.nextLine());
                                System.out.print("Street: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).getAddress().setStreet(scan.nextLine());
                                System.out.print("Home #: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).getAddress().setHome(scan.nextLine());
                                System.out.print("Apartments #: ");
                                met.get(met.size() - 1).getTeachers().get(met.get(met.size() - 1).getTeachers().size() - 1).getAddress().setApt(Integer.parseInt(scan.nextLine()));
                                met.get(met.size() - 1).getTeachers().forEach(System.out::println);


                                //-----------------------------------------------------------------------------------------Пропуск
                                break;
                            case "Skip":
                                break label1;
                        }
                    }
                    metodist:
                    while (true) {

                        System.out.println();
                        System.out.println("Redact Metodist List? Delete/Add/Skip");
                        otvetS = scan.nextLine();
                        //-------------------------------------------------------------------------Увольнение Учителя
                        switch (otvetS) {
                            case "Delete":
                                System.out.println("Какого Методиста уволить?");
                                int d = Integer.parseInt(scan.nextLine());
                                if (d > met.size() - 1) {
                                    System.out.println("Invalid number, Try Again");
                                } else {
                                    met.remove(d);
                                    met.forEach(System.out::println);
                                }

                                //-----------------------------------------------------------------------Добавление Методиста
                                break;
                            case "Add":
                                if (met.get(met.size() - 1).getTeachers().size() == 0) {                                //Еcли в массиве не остается Учителя,
                                    System.out.println("Доступных учителей для повышения нету");
                                } else {

                                    System.out.println("Выбирете методиста, у которого хотите забрать педагога");
                                    int k = Integer.parseInt(scan.nextLine());
                                    System.out.println("Какого Педагога перевести в методисты?");
                                    int r = Integer.parseInt(scan.nextLine());
                                    met.add(metConvert.convert(met.get(k).getTeachers().get(r)));
                                    met.get(k).getTeachers().remove(r);
                                }
                                met.forEach(System.out::println);
                                //-----------------------------------------------------------------------------------------Пропуск
                                break;
                            case "Skip":
                                break metodist;
                        }
                    }
                    break;
                case "No":
                    break labelPersonal;
            }
        }
        //-------------------------------------------------------------------------------------------------Результат
        groups.forEach(System.out::println);
        for (int z = 0; z < groups.size(); z++) {
            if (groups.get(z).getStud().size() > 1 && groups.get(z).getStud().size() < 5) {
                System.out.println("В группе " + groups.get(z).getStud().size() + " Ученика");
            } else if (groups.get(z).getStud().size() == 1) {
                System.out.println("В группе " + groups.get(z).getStud().size() + " Ученик");
            } else {
                System.out.println("В группе " + groups.get(z).getStud().size() + " Учеников");
            }

        }
        groups.forEach(System.out::println);




        sort:
        while (true) {
            System.out.println("Сортировать? Yes/No");
            String otvetL = scan.nextLine();


            switch (otvetL) {
                case "Yes":
                    System.out.println("Сортировать по какому критерию? Name/Surname/Age/Gender");
                    otvetL = scan.nextLine();
                    switch (otvetL) {
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
                    }
                    break;
                case "No":
                    break sort;
            }

        }

        System.out.println("Введите диапазон даты выпуска");
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        System.out.println("Список групп в заданном диапазоне");
        List<Group> cashGroup = new ArrayList<>();
        cashGroup = groups.stream().filter(x -> x.getYearEnd() < end + 1 && x.getYearEnd() > start - 1).collect(Collectors.toList());
        cashGroup.forEach(System.out::println);

        List<Teacher> cashTeach = new ArrayList<>();

        System.out.println("\nУчителя, чья зарплата выше 1000 BYN");
        cashTeach = met.get(met.size() - 1).getTeachers().stream().filter((x) -> x.getPayday() > 1000).collect(Collectors.toList());//payday
        cashTeach.forEach(System.out::println);

//        System.out.println("\nСортировка в алфавитном порядке по именам");
//        cashTeach = met.get(met.size() - 1).getTeachers().stream().sorted((x, y) -> x.getName().compareTo(y.getName())).collect(Collectors.toList());//sorted
//        cashTeach.forEach(System.out::println);

        System.out.println("\nУчителя на пенсии");
        cashTeach = met.get(met.size() - 1).getTeachers().stream().filter((x) -> (x.getGender().equals("M") && x.getAge() > 62) || (x.getGender().equals("F") && x.getAge() > 57)).collect(Collectors.toList());//age
        cashTeach.forEach(System.out::println);

        scan.close();
    }
}




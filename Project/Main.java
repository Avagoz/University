package Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int less=0;
        Group group = new Group();
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                ==================
                Group Information
                ==================\s""");                                             // Основная информация группы
        System.out.print("Group number: ");                                           //номер группы
        group.setGroup(Integer.parseInt(scan.nextLine()));
        System.out.print("Year: ");                                                   // курс
        group.setYear(Integer.parseInt(scan.nextLine()));
        System.out.print("Number of students: ");                                     //Количество студентов группе
        group.setRazmer(Integer.parseInt(scan.nextLine()));
        Group gr = new Group(group.getGroup(), group.getYear(), group.getRazmer());   //Группа, Курс, Размер группы

        gr.displayGroup();

        gr.teach.displayTeacher();
        gr.address1.displayAddress();

        for (int j = 0; j < gr.stud.size(); j++) {
            gr.stud.get(j).displayStudent();
            gr.addressStud.get(j).displayAddress();
        }
        if (gr.stud.size() > 1 && gr.stud.size() < 5) {
            System.out.println("В группе " + gr.stud.size() + " Ученика");
        } else if (gr.stud.size() == 1) {
            System.out.println("В группе " + gr.stud.size() + " Ученик");
        } else {
            System.out.println("В группе " + gr.stud.size() + " Учеников");
        }
        //---------------------------------------------------------------------------Остновная информация о Учителе
        for (;;) {
            System.out.println();
            System.out.println("Redact Teacher information? Yes/No");
            String otvetT = scan.nextLine();

            if (otvetT.equals("Yes")) {

                System.out.print("Name: ");
                gr.teach.setName(scan.nextLine());
                System.out.print("Surname: ");
                gr.teach.setSurname(scan.nextLine());
                System.out.print("Age: ");
                gr.teach.setAge(Integer.parseInt(scan.nextLine()));

                for (;;) {

                    System.out.println("Redact lessons? Yes/No");
                    String otvetL = scan.nextLine();

                    if (otvetL.equals("Yes")) {
                        System.out.print("Number of lessons: ");            //колличество занятий, отсюда будет
                        less= Integer.parseInt(scan.nextLine());
                        gr.teach.setPayday(less,gr.stud.size());            // расчитываться Зарплата преподователя
                    } else if
                    (otvetL.equals("No")) {
                        break;
                    }
                }
                System.out.println();
                System.out.println("Enter Teacher Address");
                System.out.print("City: ");
                gr.address1.setCity(scan.nextLine());
                System.out.print("Street: ");
                gr.address1.setStreet(scan.nextLine());
                System.out.print("Home #: ");
                gr.address1.setHome(scan.nextLine());
                System.out.print("Appartaments #: ");
                gr.address1.setApt(Integer.parseInt(scan.nextLine()));

            } else if (otvetT.equals("No")) {
                gr.teach.displayTeacher();
                gr.address1.displayAddress();
                break;
            }
        }
        //-------------------------------------------------------------------------	Остновная информация о Студенте

        for (;;) {
            System.out.println();
            System.out.println("Redact Student List? Delete/Add/Skip");
            String otvetS = scan.nextLine();
                //-------------------------------------------------------------------------удаление ученика из группы
            if ("Delete".equals(otvetS)) {
                System.out.println("Какого студента удалить?");
                int d = Integer.parseInt(scan.nextLine());
                if (d >= gr.stud.size()) {
                    System.out.println("Invalid number, Try Again");
                } else {
                    gr.stud = gr.deleteStud(d, gr.stud);
                    gr.addressStud = gr.deleteAddr(d, gr.addressStud);

                    for (int j = 0; j < gr.stud.size(); j++) {
                        gr.stud.get(j).displayStudent();
                        gr.addressStud.get(j).displayAddress();
                    }
                    if (gr.stud.size() > 1 && gr.stud.size() < 5) {
                        System.out.println("В группе " + gr.stud.size() + " Ученика");
                    } else if (gr.stud.size() == 1) {
                        System.out.println("В группе " + gr.stud.size() + " Ученик");
                    } else {
                        System.out.println("В группе " + gr.stud.size() + " Учеников");
                    }

                }
                //-----------------------------------------------------------------------Добавление ученика в группу
            } else if ("Add".equals(otvetS)) {
                if (gr.stud.size() == 0) {                                //Еcли в массиве не остается учеников,
                    gr.stud.add(new Student("...", "...", 0));            //то условие создает новый массив
                    gr.addressStud.add(new Address("...", "...", "...", 0));
                    gr.stud = gr.addStud(gr.stud);
                    gr.addressStud = gr.addAddr(gr.addressStud);
                    gr.stud = gr.deleteStud(0, gr.stud);
                    gr.addressStud = gr.deleteAddr(0, gr.addressStud);
                } else {
                    gr.stud = gr.addStud(gr.stud);
                    gr.addressStud = gr.addAddr(gr.addressStud);


                }

                System.out.println("""


                        Student's information
                        ---------------------""");
                System.out.print("Name: ");
                gr.stud.get(gr.stud.size() - 1).setName(scan.nextLine());
                System.out.print("Surname: ");
                gr.stud.get(gr.stud.size() - 1).setSurname(scan.nextLine());
                System.out.print("Age: ");
                gr.stud.get(gr.stud.size() - 1).setAge(Integer.parseInt(scan.nextLine()));
                System.out.println("\nEnter Student Address");
                System.out.print("City: ");
                gr.addressStud.get(gr.stud.size() - 1).setCity(scan.nextLine());
                System.out.print("Street: ");
                gr.addressStud.get(gr.stud.size() - 1).setStreet(scan.nextLine());
                System.out.print("Home #: ");
                gr.addressStud.get(gr.stud.size() - 1).setHome(scan.nextLine());
                System.out.print("Apartments #: ");
                gr.addressStud.get(gr.stud.size() - 1).setApt(Integer.parseInt(scan.nextLine()));

                for (int j = 0; j < gr.stud.size(); j++) {
                    gr.stud.get(j).displayStudent();
                    gr.addressStud.get(j).displayAddress();
                }
                if (gr.stud.size() > 1 && gr.stud.size() < 5) {
                    System.out.println("В группе " + gr.stud.size() + " Ученика");
                } else if (gr.stud.size() == 1) {
                    System.out.println("В группе " + gr.stud.size() + " Ученик");
                } else {
                    System.out.println("В группе " + gr.stud.size() + " Учеников");
                }
                //-----------------------------------------------------------------------------------------Пропуск
            } else if ("Skip".equals(otvetS)) {
                break;
            }
        }
        //-------------------------------------------------------------------------------------------------Результат
        gr.displayGroup();
        if (gr.stud.size() > 1 && gr.stud.size() < 5) {
            System.out.println("В группе " + gr.stud.size() + " Ученика");
        } else if (gr.stud.size() == 1) {
            System.out.println("В группе " + gr.stud.size() + " Ученик");
        } else {
            System.out.println("В группе " + gr.stud.size() + " Учеников");
        }
        gr.teach.setPayday(less,gr.stud.size());
        gr.teach.displayTeacher();
        gr.address1.displayAddress();

        for (int j = 0; j < gr.stud.size(); j++) {
            gr.stud.get(j).displayStudent();
            gr.addressStud.get(j).displayAddress();
        }
        scan.close();
    }
}




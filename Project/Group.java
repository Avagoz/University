package Project;

import java.util.ArrayList;

public class Group {

    private int group;
    private int year;
    private int razmer;
    Teacher teach;
    Address address1;
    ArrayList<Student> stud;
    ArrayList<Address> addressStud;
    public Group() {

    }

    public Group(int group, int year, int razmer) {
        this.group = group;
        this.year = year;
        this.razmer = razmer;
        this.stud = new ArrayList<>();
        this.addressStud = new ArrayList<>();
        this.teach = new Teacher("Ivan", "Ivanov", 29, 16,razmer);
        this.address1 = new Address("Minsk", "Pushkina", "23b", 427);

        for (int i = 0; i < getRazmer(); i++) {
            stud.add(new Student("...", "...", 0));
            addressStud.add(new Address("...", "...", "...", 0));
        }
    }

    public int getRazmer() {
        return this.razmer;
    }

    public void setRazmer(int razmer) {
        this.razmer = razmer;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group=group;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
//-------------Метод добавления ученика и его адреса-----------------------------------------------

    public ArrayList<Student> addStud(ArrayList<Student> stud) {
        stud.add(new Student(stud.get(stud.size() - 1).getName(),
                             stud.get(stud.size() - 1).getSurname(),
                             stud.get(stud.size() - 1).getAge()));
        return stud;
    }

    public ArrayList<Address> addAddr(ArrayList<Address> addressStud) {
        addressStud.add(new Address(addressStud.get(addressStud.size() - 1).getCity(),
                                    addressStud.get(addressStud.size() - 1).getStreet(),
                                    addressStud.get(addressStud.size() - 1).getHome(),
                                    addressStud.get(addressStud.size() - 1).getApt()));
        return addressStud;
    }
//-------------Метод удааления ученика и его адреса-------------------------------------------------

    public ArrayList<Student> deleteStud(int d, ArrayList<Student> stud) {
        stud.remove(d);
        return stud;
    }

    public ArrayList<Address> deleteAddr(int d, ArrayList<Address> addressStud) {
        addressStud.remove(d);
        return addressStud;
    }

    public void displayGroup() {
        System.out.println("\n\n==============" +
                           "\nGroup: " + getGroup() +
                           "\n==============" +
                           "\nYear: " + getYear() +
                           "\n==============");
    }
}

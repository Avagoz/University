package Project;

public class Student extends People {

    public Student(String name, String surname, int age) {
        super.name = name;
        super.surname = surname;
        super.age = age;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        if (name.isEmpty()) {
            super.name = "No Name!";
        } else {
            super.name = name;
        }
    }

    @Override
    public String getSurname() {
        return super.surname;
    }

    @Override
    public void setSurname(String surname) {
        if (surname.isEmpty()) {
            super.surname = "No surname!";
        } else {
            super.surname = surname;
        }
    }

    @Override
    public int getAge() {
        return super.age;
    }

    @Override
    public void setAge(int age) {
        if (age >= 18 && age < 80) {
            super.age = age;
        } else {
            System.out.println("!!! Invalid Age !!!");
        }
    }

    void displayStudent() {
        System.out.println("\n----------------------" +
                           "\nStudent's information" +
                           "\n----------------------" +
                           "\nName:" + getName()+
                           "\nSurname: " + getSurname()+
                           "\nAge: " + getAge()+"\n");
    }
}

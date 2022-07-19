package Project.model;

import Project.base.Address;
import Project.base.People;

public class Student extends People {
    public Student(){

    }

    public Student(String name, String surname,String gender, int age) {
        super.name = name;
        super.surname = surname;
        super.gender = gender;
        super.age = age;
        this.address=new Address("...", "...", "...", 0);

    }

    @Override
    public Address getAddress() {
        return super.address;
    }


    @Override
    public void setAddress(Address address) {

    }

    @Override
    public String getGender() {
        return super.gender;
    }

    @Override
    public void setGender(String gender) {
        if (gender.equals("M")){
            super.gender=gender;
        } else if(gender.equals("F")){
            super.gender=gender;
        }else {
            super.gender="Invalid gender";
        }
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
            super.age=0;
        }
    }

    @Override
    public String toString() {
        return "\n----------------------" +
                "\nStudent's information" +
                "\n----------------------" +
                "\nName:" + getName()+
                "\nSurname: " + getSurname()+
                "\nGender: "+getGender()+
                "\nAge: " + getAge()+
                "\n"+ address.toString()+"\n";
    }
}

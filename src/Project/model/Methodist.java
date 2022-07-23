package Project.model;

import Project.base.Personal;

import java.util.ArrayList;
import java.util.List;

public class Methodist extends Personal {
    private List<Teacher> teachers;





    public Methodist(){

    }

    public Methodist(String name, String surname, String gender, int age, int payday, Address address){
        super.name=name;
        super.surname=surname;
        super.gender=gender;
        super.age=age;
        super.payday=payday;
        super.address=address;
        this.teachers=new ArrayList<>();

    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    @Override
    public int getPayday() {
        return super.payday;
    }

    @Override
    public void setPayday(int payday) {

        super.payday =payday;
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

            super.gender=gender;

    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
            super.name = name;

    }

    @Override
    public String getSurname() {
        return super.surname;
    }

    @Override
    public void setSurname(String surname) {
        super.surname=surname;
    }

    @Override
    public int getAge() {
        return super.age;
    }

    @Override
    public void setAge(int age) {

            super.age = age;

    }
    public void addTeach() {
        teachers.add(new Teacher(teachers.get(teachers.size() - 1).getName(),
                teachers.get(teachers.size() - 1).getSurname(),
                teachers.get(teachers.size() - 1).getGender(),
                teachers.get(teachers.size() - 1).getAge(),
                0,teachers.get(teachers.size()-1).getAddress())
        );

    }


    public List<Teacher> deleteTeach(int d) {
        teachers.remove(d);
        return teachers;
    }



    @Override
    public String toString() {

        return "\n----------------------" +
                "\nMetodist information" +
                "\n----------------------" +
                "\nName:" + getName() +
                "\nSurname: " + getSurname() +
                "\nGender: " + getGender() +
                "\nAge: " + getAge() +
                "\n\nPayday: " + getPayday() + " BYN\n"+
                "\n"+ getAddress()+
                "\n"+ getTeachers().toString();
    }
}

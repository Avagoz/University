package Project.base;

import Project.model.Address;

public abstract class People {
    protected String name;
    protected String surname;
    protected int age;
    protected String gender;
    protected Address address;

    public abstract Address getAddress();

    public abstract void setAddress(Address address);

    public abstract String getGender();

    public abstract void setGender(String gender);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getSurname();

    public abstract void setSurname(String surname);

    public abstract int getAge();

    public abstract void setAge(int age);

    public abstract String toString();


}

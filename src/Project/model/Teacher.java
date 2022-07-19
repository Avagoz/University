package Project.model;


import Project.base.Address;
import Project.base.Personal;

public class Teacher extends Personal {
	
	




	public Teacher(String name, String surname, String gender, int age, int hour){
		super.name=name;
		super.surname=surname;
		super.gender=gender;
		super.age=age;
//		this.index=getIndex();
		super.payday=hour*15;
		super.address=new Address("...", "...", "...", 0);
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
		if (name.isEmpty()){
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
		if (surname.isEmpty()){
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
		if(age>=18&& age<80) {
			super.age = age;
		} else {
			super.age = 0;
			System.out.println("!!! Invalid Age !!!");
		}
	}
	@Override
	public int getPayday() {
		return payday;
	}
	@Override
	public void  setPayday(int hour) {
		
		if (hour<0) {
			this.payday = 0;
			System.out.println("Invalid hours");
		} else { 
		this.payday = 15*hour; //Расчет Зарплаты
				}
		
		}

//	void displayTeacher() {
//		System.out.println( "\n----------------------" +
//							"\nTeacher's information" +
//							"\n----------------------" +
//							"\nName:" + getName() +
//							"\nSurname: " + getSurname() +
//							"\nGender: " + getGender() +
//							"\nAge: " + getAge() +
//							"\n\nPayday: " + getPayday() + " BYN\n"+
//							"\n"+ address.toString()+"\n");
//	}



	@Override
	public String toString() {
		return "\n----------------------" +
				"\nTeacher information"+
				"\n----------------------" +
				"\nName:" + getName() +
				"\nSurname: " + getSurname() +
				"\nGender: " + getGender() +
				"\nAge: " + getAge() +
				"\n\nPayday: " + getPayday() + " BYN\n"+
				"\n"+ getAddress().toString()+"\n";
	}


}

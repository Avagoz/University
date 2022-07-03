package Project;


public class Teacher extends People {
	
	
	private int payday;

	public Teacher(String name, String surname, int age, int lesson,int size){
		super.name=name;
		super.surname=surname;
		super.age=age;
		this.payday=lesson*size*45;
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
			System.out.println("!!! Invalid Age !!!");
		}
	}

	public int getPayday() {
		return payday;
	}
	
	public void  setPayday(int lesson, int size) {
		
		if (lesson<0||size==0) {
			this.payday = 0;
			System.out.println("Invalid Lessons");
		} else { 
		this.payday = 45*lesson*size; //Расчет Зарплаты
				}
		
		}

	void displayTeacher() {
		System.out.println( "\n----------------------" +
							"\nTeacher's information" +
							"\n----------------------" +
							"\nName:" + getName() +
							"\nSurname: " + getSurname() +
							"\nAge: " + getAge() +
							"\n\nPayday: " + getPayday() + " BYN\n");
	}

}

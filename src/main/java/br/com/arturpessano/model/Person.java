package br.com.arturpessano.model;
import java.time.LocalDate;

public class Person {
	private String name;
	private String lastName;
	private String birthday;
	private String email;
	
	
	public Person(String name, String lastName, String birthday, String email) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public String getLastName() {
		return lastName;
	}


	public String getBirthday() {
		return birthday;
	}

}

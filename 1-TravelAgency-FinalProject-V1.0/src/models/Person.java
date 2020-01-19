package models;

public class Person {
	
	private String name;
	private long identification;
	
	public Person(String name , long identification) {
		this.name = name;
		this.identification = identification;
	}
	
	public String getName() {
		return name;
	}
	
	public long getIdentification() {
		return identification;
	}
	

}

package models;

public class Place {
	private String name;
	private int code;
	
	public Place(String name , int code) {
		this.name = name;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}
}

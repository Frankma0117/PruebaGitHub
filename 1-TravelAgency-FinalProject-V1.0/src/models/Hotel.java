package models;

public class Hotel {
	
	private String name;
	private int code;
	private Place place;
	private double price;
	
	public Hotel(String name , int code , Place place,double price) {
		this.name = name;
		this.code = code;
		this.place = place;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}
	
	public Place getPlace() {
		return place;
	}
	
	public double getPrice() {
		return price;
	}



	public String toString() {
		return " Hotel = " + name + "\n" +  "Precio = " + price 
				+ "\n" +  "Lugar del hotel = " + place.getName() + "\n" +  "Codigo del hotel = " + code  ;
	}
	
	

}

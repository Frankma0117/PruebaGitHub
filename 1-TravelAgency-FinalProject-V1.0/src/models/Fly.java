package models;
import enums.*;

public class Fly {
	private FlyType type;
	private double price;
	private Place place;
	private int code;
	
	public Fly(FlyType type , double price , Place place,int code) {
		this.type = type;
		this.price = price;
		this.place = place;
		this.code = code;
	}
	
	public FlyType getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Place getPlace() {
		return place;
	}

	public int getCode() {
		return code;
	}
	
	public String toString() {
		return " Tipo de vuelo = " + type + "\n" +  "Precio = " + price 
				+ "\n" +  "Punto de llegada = " + place.getName() + "\n" +  "Codigo del vuelo = " + code  ;
	}
	
	
	
}

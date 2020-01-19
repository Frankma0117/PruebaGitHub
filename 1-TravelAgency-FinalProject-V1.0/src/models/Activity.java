package models;
import enums.*;

public class Activity {
	private String name;
	private TypeActivity typeActivity;
	private Date dayOfActivity;
	private int durationActivity;
	private int timeStartActivity;
	private Place place;
	private int quotas = 20;
	private double price;
	private int code;
	
	public Activity(String name , int code , double price,TypeActivity typeActivity , int timeStartActivity , int durationActivity,Place place) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.typeActivity = typeActivity;
		this.durationActivity = durationActivity;
		this.timeStartActivity = timeStartActivity;
		this.place = place;
	}
	
	public void setDayOfActivity(Date dayOfActivity) {
		this.dayOfActivity = dayOfActivity;
	}
		
	public String getName() {
		return name;
	}
	
	public TypeActivity getTypeActivity() {
		return typeActivity;
	}
	
	public int getDurationActivity() {
		return durationActivity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getTimeStartActivity() {
		return timeStartActivity;
	}
	
	public Place getPlace() {
		return place;
	}
	
	public int getQuotas() {
		return quotas;
	}
	
	public Date getDayOfActivity() {
		return dayOfActivity;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setQuotas(int quotas) {
		this.quotas = quotas;
	}

	public String toString() {
		return  "***"+ name + "\n" + "Area de desempeño de la actividad = " + typeActivity
				+ "\n" + "Dia de la actividad = " + dayOfActivity
				+ "\n" + "Duracion en horas de la actividad = " + durationActivity
				+ "\n" + "Tiempo de inicio de la actividad = " + timeStartActivity 
				+ "\n" + "Cupos disponibles = " + quotas + "\n" + "Precio de la actividad = " + price
				+ "\n" + "Lugar de la actividad = " + place.getName() 
				+ "\n" + "Codigo de la actividad = " + code ;
	}
	
	
	
	

}

package models;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	public Date(int day ,int month , int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		adjustDate();
	}
	
	public int getDay() {
		return day;
	}
	
	public void increase(int days) {
		day += days;
		adjustDate();
	}
	
	/*public Date increase2(Date date,int days) {
		date.day += days;
		date.adjustDate();
		return date;
	}*/
	
	public String toString(){
		return day + "/" + month + "/" + year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void adjustDate() {
		adjustDay();
		adjustMonth();
	}
	
	private void adjustDay(){
		while (day > 30 ){
			month++;
			day -=30;
		}
		
	} 
	
	private void adjustMonth(){
		while (month > 12 ){
			year++;
			month -=12;
		}	
	}
	
}
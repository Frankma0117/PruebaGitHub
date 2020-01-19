 

package models;

public class TripPlan {
	private Place place;
	private Fly fly;
	private Hotel hotel;
	private Activity activity1;
	private Activity activity2;
	private Activity activity3;
	private double price;
	private Date departureDate;
	private Date returnDate;
	private int quotas = 50;
	private int code;
	private int PRICE_LIFE_INSURANCE = 15000;

	public TripPlan(Place place, int code , Fly fly , Hotel hotel ) {
		this.place = place;
		this.fly = fly;
		this.hotel = hotel;
		this.code = code;
	}
	
	public void setActivities(Activity activity1 , Activity activity2 , Activity activity3) {
		this.activity1 = activity1;
		this.activity2 = activity2;
		this.activity3 = activity3;
	}
	
	public void setTravelDates(Date departureDate) {
		this.departureDate = departureDate;
		returnDate = new Date(departureDate.getDay()+5,departureDate.getMonth(), departureDate.getYear());					
	}
	
	public void calculatePriceTripPlan() {
		price =   priceActivities() + priceHotelAndFly() + PRICE_LIFE_INSURANCE;
	}
	
	public double priceActivities() {
		return activity1.getPrice() + activity2.getPrice() +  activity3.getPrice();
	}
	
	public double priceHotelAndFly() {
		return hotel.getPrice() + fly.getPrice();
	}
	
	public Place getPlace() {
		return place;
	}
	
	public Fly getFly() {
		return fly;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public Date getDepartureDay() {
		return departureDate;
	}
	
	public Date getReturnDay() {
		return returnDate;
	}
	
	public Activity getActivity1 () {
		return activity1;
	}
	
	public Activity getActivity2 () {
		return activity2;
	}
	
	public Activity getActivity3() {
		return activity3;
	}
	
	public int getCode() {
		return code;
	}
	
	public int getQuotas() {
		return quotas;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setQuotas(int quotas) {
		this.quotas = quotas;
	}


	public String toString() {
		return " El plan de viaje con destino a " + place.getName() 
				+"\n" + "Codigo del plan de viaje " +  this.code
				+"\n" + "Cupos disponibles " + this.quotas
				+ "\n" + "Fecha de viaje " + this.getDepartureDay()
				+"\n" + fly.toString() 
				+ "\n" +  hotel.toString()
				+ "\n" + "Las actividades del plan son : " 
				+ "\n" + activity1.toString()
				+ "\n" + activity2.toString()
				+ "\n" + activity3.toString();
	}
	
	
	

	
	
}

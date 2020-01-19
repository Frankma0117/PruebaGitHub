package models;
import enums.*;
import exceptions.ExistenceDateOfActivityException;
import exceptions.TravelWithOutQuotaException;

public class TravelAgency {
	
	private Reservation[] reservations;
	private TripPlan[] tripPlans;
	private Activity[] activities;
	private Client[] clients;
	private Place[] placesToTravel;
	private Hotel[] hotelsToTravel;
	private Fly[] flights;
	private Employment[] employments;
	private EmploymentActivity[] employmentsActivities;
	
	public TravelAgency(int numberClients , int numberTripPlans , int numberEmployments) {
		clients = new Client[numberClients];
		tripPlans = new TripPlan[numberTripPlans];
		activities = new Activity[numberTripPlans * 3 ];
		reservations = new Reservation[numberClients];	
		placesToTravel = new Place[numberTripPlans];
		hotelsToTravel = new Hotel[numberTripPlans];
		flights = new Fly[numberTripPlans];
		employments = new Employment[numberEmployments];
		employmentsActivities = new EmploymentActivity[numberTripPlans * 3 ];
	}
	
	public void registerClient(String name , long identification , long cellPhoneNumber) {
		for(int index=0; index<clients.length;index++){
			if(clients[index]== null){
				clients[index] = new Client(name,identification,cellPhoneNumber);
				break;
			}
		}
	}
 	
	public void reservTripPlan(Client client , TripPlan tripPlan , int code ) throws TravelWithOutQuotaException {
		for(int index=0; index<reservations.length;index++){
			if(reservations[index] == null){
				reservations[index] = new Reservation(client,tripPlan,code);
				tripPlan.setQuotas(tripPlan.getQuotas()-1);
				tripPlan.getActivity1().setQuotas(tripPlan.getActivity1().getQuotas()-1);
				tripPlan.getActivity2().setQuotas(tripPlan.getActivity2().getQuotas()-1);
				tripPlan.getActivity3().setQuotas(tripPlan.getActivity3().getQuotas()-1);
				break;
			}
		}
	}
		
	public void addDepartureDate(int codeReservation , Date departureDate) {
		askReservation(codeReservation).getTripPlan().setTravelDates(departureDate);
		askReservation(codeReservation).getTripPlan().getActivity1().setDayOfActivity(departureDate);
		Date date2 = new Date(departureDate.getDay(),departureDate.getMonth(),departureDate.getYear());
		date2.increase(2);
		askReservation(codeReservation).getTripPlan().getActivity2().setDayOfActivity(date2);
		Date date3 = new Date(date2.getDay(),date2.getMonth(),date2.getYear());
		date3.increase(2);
		askReservation(codeReservation).getTripPlan().getActivity3().setDayOfActivity(date3);
	}
	
	public Reservation askReservation(int codeReservation) {
		int indexAux=0;
			for(int index=0; index<reservations.length;index ++){
				if(reservations[index] != null){
					if(codeReservation==reservations[index].getCodeReservation()){	
						indexAux = index;
					}
				}
			} return reservations[indexAux];
	}
	
	public Activity askActivity(int codeActivity) {
		int indexAux=0;
			for(int index=0; index<activities.length;index ++){
				if(activities[index] != null){
					if(codeActivity==activities[index].getCode()){	
						indexAux = index;
					}
				}
			} return activities[indexAux];
	}
	
	public Client askClient(long identification) {
		int indexAux=0;
			for(int index=0; index<clients.length;index ++){
				if(clients[index] != null){
					if(identification==clients[index].getIdentification()){	
						indexAux = index;
					}
				}
			} return clients[indexAux];
	}
	
	public TripPlan askTripPlan(int codeTripPlan) {
		int indexAux=0;
		for(int index=0; index<tripPlans.length;index ++){
			if(tripPlans[index] != null){
				if(codeTripPlan==tripPlans[index].getCode()){	
					indexAux = index;
				}
			}
		} return tripPlans[indexAux];
	}
	
	public double consultValueTripPlan(int codeReservation) {
		askReservation(codeReservation).getTripPlan().calculatePriceTripPlan();
		return askReservation(codeReservation).getTripPlan().getPrice();
	}	
	
	public void createPlaceOfTravel(String name , int code) {
		for(int index=0; index<placesToTravel.length;index++){
			if(placesToTravel[index]== null){
				placesToTravel[index] = new Place(name,code);
				break;
			}
		}
	}
	
	public void createHotelOfTravel(String name , int code , int placeCode ,double price) {
		for(int index=0; index<hotelsToTravel.length;index++){
			if(hotelsToTravel[index]== null){
				hotelsToTravel[index] = new Hotel(name,code,askPlace(placeCode),price);
				break;
			}
		}
	}
	
	public void createActivity(String name , int code , double price,TypeActivity typeActivity , int timeStartActivity , int durationActivity,Place place) {
		for(int index=0; index<activities.length;index++){
			if(activities[index]== null){
				activities[index] = new Activity(name,code,price,typeActivity,timeStartActivity,durationActivity,place);
				break;
			}
		}
	}
	
	public void createdFly(FlyType type , double price , int placeCode , int code) {
		for(int index=0; index<flights.length;index++){
			if(flights[index]== null){
				flights[index] = new Fly(type,price,askPlace(placeCode),code);
				break;
			}
		}	
	}
	
	public Place askPlace(int placeCode) {
		int indexAux=0;
		for(int index=0; index<placesToTravel.length;index ++){
			if(placesToTravel[index] != null){
				if(placeCode==placesToTravel[index].getCode()){	
					indexAux = index;
				}
			}
		} return placesToTravel[indexAux];
	}
	
	public Fly askFly(int flyCode) {
		int indexAux=0;
		for(int index=0; index<flights.length;index ++){
			if(flights[index] != null){
				if(flyCode==flights[index].getCode()){	
					indexAux = index;
				}
			}
		} return flights[indexAux];
	}
	
	public Hotel askHotel(int hotelCode) {
		int indexAux=0;
		for(int index=0; index<hotelsToTravel.length;index ++){
			if(hotelsToTravel[index] != null){
				if(hotelCode==hotelsToTravel[index].getCode()){	
					indexAux = index;
				}
			}
		} return hotelsToTravel[indexAux];
	}
	
	public void createdTripPlan(Place place, int code , Fly fly , Hotel hotel,Activity activity1,Activity activity2,Activity activity3) {
		for(int index=0; index<tripPlans.length;index++){
			if(tripPlans[index]== null){
				if(place.getCode() == fly.getPlace().getCode() && place.getCode() == hotel.getPlace().getCode() ) {
				tripPlans[index] = new TripPlan(place,code,fly,hotel);	
					if(activity1.getPlace().getCode() == place.getCode() && activity2.getPlace().getCode() == place.getCode()&& activity3.getPlace().getCode() == place.getCode()  ) {
						tripPlans[index].setActivities(activity1, activity2, activity3);
						break;
					}
				}
			}
		}
	}
	
	public void createdTripPlan2(TripPlan tripPlan) {
		boolean running = true;
		for(int index=0; index<tripPlans.length && running;index++){
			if(tripPlans[index]== null){
				tripPlans[index] = tripPlan; 
				running = false;
			if(activities[index] == null) {
				activities[index]= tripPlan.getActivity1();
				activities[index+1]= tripPlan.getActivity2();
				activities[index+2]= tripPlan.getActivity3();
				running = false;
			}
				}
			}
		
	}
	
	
	public void retiredClient(long identification){
		for(int index=0; index<clients.length;index ++){
			if(clients[index] != null){
				if(identification ==clients[index].getIdentification()){	
					clients[index] = null;	
				}
				if(identification ==reservations[index].getClient().getIdentification()){	
					reservations[index] = null;	
				}
			}
		} 
	}
	
	public void registerEmployment(String name , long identification , TypeActivity type) {
		
		for(int index=0; index<employments.length;index++){
			if(employments[index]== null){
				employments[index] = new Employment(name,identification,type);
				break;
			}
		}
	}
	
	public void assignActivityEmployment(long identificationEmployment , int codeActivity , int codeAssing) throws ExistenceDateOfActivityException{
		Employment employment = askEmployment(identificationEmployment);
		Activity activity = askActivity(codeActivity);
		for(int index=0; index<employmentsActivities.length;index++){
			if(employmentsActivities[index]== null){
				employmentsActivities[index] = new EmploymentActivity(activity,employment,codeAssing);
				break;
			}
		}
	}
	
	public Employment askEmployment(long identification) {
		int indexAux=0;
			for(int index=0; index<employments.length;index ++){
				if(employments[index] != null){
					if(identification==employments[index].getIdentification()){	
						indexAux = index;
					}
				}
			} return employments[indexAux];
	}
	
	public EmploymentActivity[] sheduleEmployment(long identification){
		EmploymentActivity[] activitiesEmployment =  new EmploymentActivity[activities.length];
		for(int index=0; index<employmentsActivities.length;index ++){
			if(employmentsActivities[index] != null){
				if(identification == employmentsActivities[index].getEmployment().getIdentification()){	
					activitiesEmployment[index] = employmentsActivities[index];
				}
			}
		} return activitiesEmployment;
	}
	
	public void retiredEmployment(long identification){
		for(int index=0; index<employments.length;index ++){
			if(employments[index] != null){
				if(identification ==employments[index].getIdentification()){	
					employments[index] = null;	
				}
			}
		} 
	}
	
	public void retiredActivityEmploymnet( int codeAssing){
		for(int index=0; index<employmentsActivities.length;index ++){
			if(employmentsActivities[index] != null){
				if(codeAssing ==employmentsActivities[index].getCode()){	
					employmentsActivities[index] = null;	
				}
			}
		} 
	}
	
	public TripPlan[] getTripPlans(){
		return tripPlans;
	}
	
	public Activity[] getActivities() {
		return activities;
	}
}

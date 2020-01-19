package controller;
import models.*;
import views.*;
import enums.*;
import exceptions.ExistenceDateOfActivityException;
import exceptions.TravelWithOutQuotaException;

public class Controller {
	
	private TravelAgency travelAgencyObj;
	private View viewObj;
	
	public Controller() {
		viewObj = new View();
		travelAgencyObj = new TravelAgency(viewObj.readInt(Text.READ_NUMBER_CLIENTS.toString()),
		viewObj.readInt(Text.READ_NUMBER_TRIP_PLANS.toString()),
		viewObj.readInt(Text.READ_NUMBER_EMPLOYMENTS.toString()));
		createTripPlans();
		run();
	}
	
	public void run() {

		boolean running = true;
		while(running){
		switch(viewObj.showMenu()) { 
		
			case GERENCY :
				GerencyMenu();
				break;
		
			case CLIENT:
				ClientMenu();
				break;
		
			case EXIT:
				running = false;
				break;
			}
		}
	}
	
	public void GerencyMenu() {
		boolean running = true;
		while(running) {
			switch(viewObj.showGerencyMenu()) {
		
			case CREATED_PLACE_TRAVEL:
				createPlace();
				break;
				
			case CREATED_FLY_TRAVEL:
				createFly();
				break;
				
			case CREATED_HOTEL_TRAVEL:
				createHotel();
				break;
				
			case CREATED_ACTIVITY_TRAVEL:
				createActivity();
				break;	
				
			case CREATED_TRIP_PLAN:
				createdTripPlan();
				break;
		
			case REGISTER_EMPLOYMENT:
				registerEmployment();
				break;
				
			case SHOW_ACTIVITIES:
				showActivities();
				break;
		
			case ASSING_ACTIVITIES_EMPLOYMENT:
				assingActivities();
				break;
			
			case SHOW_SHEDULE_EMPLOYMENT:
				sheduleEmployment();
				break;
		
			case RETIRED_ACTIVITY_EMPLOYMENT:
				retiredActivityEmployment();
				break;
		
			case RETIRED_EMPLOYMENT:
				retiredEmployment();
				break;
			
			case RETURN_PRINCIPAL_MAIN:
				run();
				break;
		
			case EXIT:
				running = false;
				break;
			
			}
		}
	}
	
	public void createdTripPlan() {
		travelAgencyObj.createdTripPlan(travelAgencyObj.askPlace(viewObj.readInt(Text.READ_CODE_PLACE.toString())),
				viewObj.readInt(Text.READ_CODE_TRIP_PLAN.toString()),
				travelAgencyObj.askFly(viewObj.readInt(Text.READ_CODE_FLY.toString())), 
				travelAgencyObj.askHotel(viewObj.readInt(Text.READ_CODE_HOTEL.toString())),
				travelAgencyObj.askActivity(viewObj.readInt(Text.READ_CODE_ACTIVITY.toString()+" 1")),
				travelAgencyObj.askActivity(viewObj.readInt(Text.READ_CODE_ACTIVITY.toString()+" 2")),
				travelAgencyObj.askActivity(viewObj.readInt(Text.READ_CODE_ACTIVITY.toString()+" 3")));
	}
	
	public void createPlace() {
		viewObj.showMessage(Text.SHOW_MESSAGE_CREATED_FEATURES.toString());
		travelAgencyObj.createPlaceOfTravel(viewObj.readString(Text.READ_NAME_PLACE.toString()),
				viewObj.readInt(Text.READ_CODE_PLACE.toString()));
	}
	
	public void createFly() {
		travelAgencyObj.createdFly(viewObj.readFlyType(Text.MESSAGE_FLY_TYPE.toString()),
				viewObj.readDouble(Text.MESSAGE_PRICE_FLY.toString()),viewObj.readInt(Text.READ_CODE_PLACE.toString()), viewObj.readInt(Text.READ_CODE_FLY.toString()));
		
	}
	
	public void createHotel() {
		travelAgencyObj.createHotelOfTravel(viewObj.readString(Text.READ_HOTEL_NAME.toString()),
				viewObj.readInt(Text.READ_CODE_HOTEL.toString()),viewObj.readInt(Text.READ_CODE_PLACE.toString()), viewObj.readDouble(Text.READ_HOTEL_PRICE.toString()));
	}
	
	public void createActivity() {
		travelAgencyObj.createActivity(viewObj.readString(Text.READ_NAME_ACTIVITY.toString()), 
				viewObj.readInt(Text.READ_CODE_ACTIVITY.toString()),
				viewObj.readDouble(Text.READ_PRICE_ACTIVITY.toString()),
				viewObj.readTypeActivity(Text.READ_TYPE_ACTIVITY.toString()),
				viewObj.readInt(Text.READ_TIME_START_ACTIVITY.toString()), viewObj.readInt(Text.READ_DURATION_ACTIVITY.toString()),
				travelAgencyObj.askPlace(viewObj.readInt(Text.READ_CODE_PLACE.toString())));
	}
	
	public void registerEmployment() {
		travelAgencyObj.registerEmployment(viewObj.readString(Text.READ_NAME_EMPLOYMENT.toString()),
				viewObj.readInt(Text.READ_ID_EMPLOYMENT.toString()), viewObj.readTypeActivity(Text.READ_TYPE_EMPLOYMENT.toString()));
	}
	
	public void showActivities() {
		viewObj.showActivities(travelAgencyObj.getActivities());
	}
	
	public void assingActivities() {
		try {	travelAgencyObj.assignActivityEmployment(viewObj.readInt(Text.READ_ID_EMPLOYMENT.toString()),
					viewObj.readInt(Text.READ_CODE_ACTIVITY.toString()), viewObj.readInt(Text.READ_CODE_ASSING_ACTIVITY.toString()));
		} catch (ExistenceDateOfActivityException exception) {
			viewObj.showMessageExceptions(exception.getMessage());
		}
	}
	
	public void retiredActivityEmployment() {
		travelAgencyObj.retiredActivityEmploymnet(viewObj.readInt(Text.READ_CODE_ASSING_ACTIVITY.toString()));
	}
	
	public void retiredEmployment() {
		travelAgencyObj.retiredEmployment(viewObj.readInt(Text.READ_ID_EMPLOYMENT.toString()));
	}
		
		
	public void ClientMenu() {
		boolean running = true;
		while(running) {
			switch(viewObj.showClientMenu()){
				
			case REGISTER_CLIENT:
				createClient();
				break;
				
			case SHOW_TRIP_PLANS:
				showTripPlans();
				break;
			
			case RESERV_TRIP_PLANS:
				reservPlan();
				break;
				
			case ADD_DEPARTURE_DATE:
				addDepartureDate();
				break;
				
			case ASK_RESERV:
				askReservation();
				break;
				
			case CALCULATE_VALUE:
				calculateTotalValueTripPlan();
				break;
				
			case CREATE_SHEDULE:
				creteSheduleClient();
				break;
				
			case RETIRED_CLIENT:
				retiredClient();
				break;
				
			case RETURN_PRINCIPAL_MAIN:
				run();
				break;
				
			case EXIT:
				running = false;
				break;
			}
		}
		
	}
	
	public void createClient() {
	travelAgencyObj.registerClient(viewObj.readString(Text.READ_NAME_CLIENT.toString()),
				viewObj.readLong(Text.READ_ID_CLIENT.toString()),
				viewObj.readLong(Text.READ_CELL_PHONE_NUMBER.toString()));
		viewObj.showMessage(Text.SUCESFULL_REGISTRATION.toString());
	}
	
	public void showTripPlans(){
		viewObj.showResultTripPlans(travelAgencyObj.getTripPlans());
	}
	
	public void reservPlan() {
		try {
			travelAgencyObj.reservTripPlan(travelAgencyObj.askClient(viewObj.readInt(Text.READ_ID_CLIENT.toString())),
					travelAgencyObj.askTripPlan(viewObj.readInt(Text.READ_CODE_TRIP_PLAN.toString())),
							viewObj.readInt(Text.READ_CODE_RESERVATION.toString()));
		} catch (TravelWithOutQuotaException exception) {
			viewObj.showMessageExceptions(exception.getMessage());
			showTripPlans();
		}
	}
	
	public void addDepartureDate() {
		int codeReservation = viewObj.readInt(Text.READ_CODE_RESERVATION.toString());
		int dayOfTravel = viewObj.readInt(Text.READ_DAY_OF_TRAVEL.toString());
		int monthOfTravel = viewObj.readInt(Text.READ_MONTH_OF_TRAVEL.toString());
		int yearOfTravel = viewObj.readInt(Text.READ_YEAR_OF_TRAVEL.toString());
		Date dateActivity = new Date(dayOfTravel,monthOfTravel,yearOfTravel);
		travelAgencyObj.addDepartureDate(codeReservation, dateActivity);
		viewObj.showMessage(Text.SHOW_MESSAGE_DATE_DEPARTURE.toString());
	}
	
	public void askReservation() {
		Reservation reservation = travelAgencyObj.askReservation(viewObj.readInt(Text.READ_CODE_RESERVATION.toString()));
		viewObj.showMessage(reservation.toString());
	}
	
	public void calculateTotalValueTripPlan() {
		viewObj.showMessage(Text.SHOW_VALUE_TOTAL.toString() + travelAgencyObj.consultValueTripPlan(viewObj.readInt(Text.READ_CODE_RESERVATION.toString())));
	}
	
	public void creteSheduleClient() {
		int codeReservation = viewObj.readInt(Text.READ_CODE_RESERVATION.toString());
		travelAgencyObj.askReservation(codeReservation).fillSheduleClient();
		viewObj.showSheduleClient(travelAgencyObj.askReservation(codeReservation).getSheduleClient());
	}
	
	public void retiredClient() {
		travelAgencyObj.retiredClient(viewObj.readInt(Text.READ_ID_CLIENT.toString()));
		viewObj.showMessage(Text.SHOW_MESSAGE_RETIRED_CLIENT.toString());
	}
	
	public void sheduleEmployment() {
		viewObj.showResultEmploymentActivities(travelAgencyObj.sheduleEmployment(viewObj.readInt(Text.READ_ID_EMPLOYMENT.toString())));
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
	public void createTripPlans() {
		Place place1 = new Place("Cartagena",2121);
		Place place2 = new Place("Manizales",3399);
		Place place3 = new Place("Amazonas",2154);
		Fly fly1Charter = new Fly(FlyType.CHARTER,95000,place1,2233);
		Fly fly2Economic = new Fly(FlyType.ECONOMICO,95000,place2,2222);
		Fly fly3Ejecutive = new Fly(FlyType.EJECUTIVO,225000,place3,1010);
		Hotel hotel1 = new Hotel("Cap",1942,place1,200000);
		Hotel hotel2 = new Hotel("Raiden",2753,place2,700000);
		Hotel hotel3 = new Hotel("Widow",3752,place3,500000);
		Activity activity1Place1 = new Activity("Buceo",2000,90000,TypeActivity.DEPORTIVA, 8 , 2 , place1);
		Activity activity2Place1 = new Activity("Museo",1000,70000,TypeActivity.CULTURAL,12 , 1 , place1);
		Activity activity3Place1 = new Activity("Caminata ecologica",3000,20000,TypeActivity.AMBIENTAL,15 , 5 , place1);
		Activity activity1Place2 = new Activity("Canotaje y rafting en el Cauca",7000,100000,TypeActivity.DEPORTIVA, 7 , 3 , place2);
		Activity activity2Place2 = new Activity("Concierto de los Beatles en Cali ",8000,70000,TypeActivity.CULTURAL, 11 , 5 , place2);
		Activity activity3Place2 = new Activity("Recoleccion de cafe en la Hacienda",9000,55000,TypeActivity.AMBIENTAL, 20 , 1 , place2);
		Activity activity1Place3 = new Activity("Visita al zoologico",4000,350000,TypeActivity.AMBIENTAL, 6 , 4 , place3);
		Activity activity2Place3 = new Activity("Avistamiento de delfines",5000,60000,TypeActivity.CULTURAL,16 , 5 , place3);
		Activity activity3Place3 = new Activity("Kayak",6000,80000,TypeActivity.DEPORTIVA, 14 , 2 , place3);
		TripPlan tripPlanCartagena = new TripPlan(place1, 2121 , fly1Charter , hotel1 );
		tripPlanCartagena.setActivities(activity1Place1, activity2Place1, activity3Place1);
		TripPlan tripPlanManizales = new TripPlan(place2, 3399 , fly2Economic , hotel2 );
		tripPlanManizales.setActivities(activity1Place2, activity2Place2, activity3Place2);
		TripPlan tripPlanAmazonas = new TripPlan(place3, 2154 , fly3Ejecutive , hotel3 );
		tripPlanAmazonas.setActivities(activity1Place3, activity2Place3, activity3Place3);
		travelAgencyObj.createdTripPlan2(tripPlanCartagena);
		travelAgencyObj.createdTripPlan2(tripPlanManizales);
		travelAgencyObj.createdTripPlan2(tripPlanAmazonas);	
	}
	
	
}




package models;

import exceptions.TravelWithOutQuotaException;

public class Reservation {
	
	private Client client;
	private TripPlan tripPlan;
	private int codeReservation;
	private String[][] sheduleClient;
	
	public Reservation(Client client , TripPlan tripPlan , int codeReservation) throws TravelWithOutQuotaException {
		if(tripPlan.getQuotas() == 0) {
			throw new TravelWithOutQuotaException();
		}
		this.client = client;
		this.tripPlan = tripPlan;
		this.codeReservation=codeReservation;
		sheduleClient = new String[25][6];
	}
	
	public Client getClient() {
		return client;
	}
	
	public TripPlan getTripPlan() {
		return tripPlan;
	}
	
	public int getCodeReservation() {
		return codeReservation;
	}
	
	public void fillSheduleClient() {
		fillTitlesShedule();
		fillActivity1SheduleClient();
		fillActivity2SheduleClient();
		fillActivity3SheduleClient();
	}
	
	public void fillTitlesShedule(){
		for(int indexj = 1 ; indexj < sheduleClient[0].length ; indexj ++) {
			sheduleClient[0][0] = "_"+"__" + " _  ";
			sheduleClient[0][indexj] = "________" +  tripPlan.getDepartureDay().toString() + "________";
			this.tripPlan.getDepartureDay().increase(1);
		for(int indexi=1 ; indexi < sheduleClient.length ; indexi ++)
			if(indexi<10) {
				sheduleClient[indexi][0] = "0"+indexi + " h  ";
			}else {
				sheduleClient[indexi][0] =indexi + " h  ";
			}
		}
	}
	
	public void fillActivity1SheduleClient(){
		int timeTotal = tripPlan.getActivity1().getTimeStartActivity() + tripPlan.getActivity1().getDurationActivity();
		for(int index = tripPlan.getActivity1().getTimeStartActivity(); index < timeTotal ; index++ ) {
			sheduleClient[index][1] = tripPlan.getActivity1().getName() ;
		}
	}
	
	public void fillActivity2SheduleClient(){
		int timeTotal = tripPlan.getActivity2().getTimeStartActivity() + tripPlan.getActivity2().getDurationActivity();
		for(int index = tripPlan.getActivity2().getTimeStartActivity(); index < timeTotal ; index++ ) {
			sheduleClient[index][3] = tripPlan.getActivity2().getName();
		}
	}
	
	public void fillActivity3SheduleClient(){
		int timeTotal = tripPlan.getActivity3().getTimeStartActivity() + tripPlan.getActivity3().getDurationActivity();
		for(int index = tripPlan.getActivity3().getTimeStartActivity(); index < timeTotal ; index++ ) {
			sheduleClient[index][5] =  tripPlan.getActivity3().getName();
		}
	}
	
	public String[][] getSheduleClient(){
		return sheduleClient;
	}

	public String toString() {
		return "La reservacion del plan de viaje para el cliente : " + client.getName() 
		+"es : " + "\n"  + tripPlan.toString();
	}

	
	
	

}

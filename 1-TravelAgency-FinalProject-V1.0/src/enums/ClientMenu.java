package enums;

public enum ClientMenu {
	
	REGISTER_CLIENT("Registrar cliente "),
	SHOW_TRIP_PLANS("Mostrar los planes de viaje disponibles "),
	RESERV_TRIP_PLANS("Reservar un plan de viaje "),
	ADD_DEPARTURE_DATE("Agregar la fecha de viaje a un plan ya reservado "),
	ASK_RESERV("Mostrar las caracteristicas de mi reserva"),
	CALCULATE_VALUE("Calcular el valor total de un plan de viaje"),
	CREATE_SHEDULE("Mostar el cronograma de mi plan de viaje reservado"),
	RETIRED_CLIENT("Retirar un cliente de la agencia de viajes"),
	RETURN_PRINCIPAL_MAIN("Retornar al menu principal"),
	EXIT("Salir del sistema");
	
	private final String text;
	
	private ClientMenu(String text) {
		this.text=text;
	}
	
	public String toString() {
		return text;
	}
	

}

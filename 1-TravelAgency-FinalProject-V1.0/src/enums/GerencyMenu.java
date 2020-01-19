package enums;

public enum GerencyMenu {
	CREATED_PLACE_TRAVEL("Crear un lugar para viajar"),
	CREATED_FLY_TRAVEL("Crear un vuelo para la agencia"),
	CREATED_HOTEL_TRAVEL("Crear un hotel para la estadia de los clientes"),
	CREATED_ACTIVITY_TRAVEL("Crear una actividad para la diversion de los clientes"),
	CREATED_TRIP_PLAN("Crear un plan de viaje"),
	REGISTER_EMPLOYMENT("Registrar empleado"),
	SHOW_ACTIVITIES("Mostrar actividades disponibles para asignar al empleado"),
	ASSING_ACTIVITIES_EMPLOYMENT("Asignar una actividad a un empleado"),
	SHOW_SHEDULE_EMPLOYMENT("Mostrar las actividades asiganadas a un empleado"),
	RETIRED_ACTIVITY_EMPLOYMENT("Retirar una actividad de un empleado"),
	RETIRED_EMPLOYMENT("Retirar empleado de sistema"),
	RETURN_PRINCIPAL_MAIN("Retornar al menu principal"),
	EXIT("Salir del sistema");
	
	private final String text;
	
	private GerencyMenu(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	

}

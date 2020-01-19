package enums;

public enum Text {
	
	READ_NUMBER_CLIENTS("Ingrese el numero maximo de clientes que su agencia registrara"),
	READ_NUMBER_TRIP_PLANS("Ingrese el numero maximo de planes de viaje que su agencia creara"),
	READ_NUMBER_EMPLOYMENTS("Ingrese el numero maximo de empleados que su agencia contratara"),
	READ_NAME_CLIENT("Ingrese el nombre del cliente"),
	READ_ID_CLIENT("Ingrese el numero de cedula del cliente"),
	READ_CELL_PHONE_NUMBER("Ingrese el numero de celular del cliente"),
	SUCESFULL_REGISTRATION("El registro del cliente se realizo con exito"),
	READ_CODE_TRIP_PLAN("Ingrese el codigo del plan de viaje"),
	READ_NAME_PLACE("Ingrese el nombre del lugar de viaje"),
	READ_CODE_PLACE("Ingrese un codigo especifico para el lugar de viaje que desea agregar"),
	MESSAGE_FLY_TYPE("Seleccione el tipo de vuelo que desea crear"),
	MESSAGE_PRICE_FLY("Ingrese el costo que tendra este vuelo"),
	READ_CODE_FLY("Ingrese un codigo para el vuelo a crear"),
	READ_HOTEL_NAME("Ingrese el nombre del hotel que desea agregar "),
	READ_CODE_HOTEL("Ingrese un codigo especifico para el hotel que desea agregar"),
	READ_HOTEL_PRICE("Ingrese el precio del hospedaje en este hotel"),
	READ_NAME_EMPLOYMENT("Ingrese el nombre del empleado"),
	READ_ID_EMPLOYMENT("Ingrese el numero de la cedula del empleado"),
	READ_TYPE_EMPLOYMENT("Ingrese le tipo de actividad en la que se desempeña el empleado"),
	READ_NAME_ACTIVITY("Ingrese el nombre de la actividad"),
	READ_CODE_ACTIVITY("Ingrese un codigo para la actividad a crear"),
	READ_PRICE_ACTIVITY("Ingrese el precio de la actividad "),
	READ_TYPE_ACTIVITY("Ingrese el tipo de actividad"),
	READ_TIME_START_ACTIVITY("Ingrese la hora de inicio de la actividad"),
	READ_CODE_RESERVATION("Ingrese un codigo para la reserva"),
	READ_DAY_OF_TRAVEL("Ingrese el dia de viaje en numeros"),
	READ_MONTH_OF_TRAVEL("Ingrese el mes del viaje en numeros"),
	READ_YEAR_OF_TRAVEL("Ingrese el año del viaje en numeros sin puntos"),
	READ_DURATION_ACTIVITY("Ingrese el numero de horas que dura la actividad"),
	READ_CODE_ASSING_ACTIVITY("Ingrese el codigo para la asignacion de la actividad al empleado"),
	SHOW_MESSAGE_DATE_DEPARTURE("La fecha de viaje fue agregada con exito"),
	SHOW_VALUE_TOTAL("El valor total del viaje es : "),
	SHOW_MESSAGE_RETIRED_CLIENT("El cliente se retiro del sistema con exito"),
	SHOW_MESSAGE_SHEDULE_CLIENT(""),
	SHOW_MESSAGE_CREATED_FEATURES("Bienvenido al sistema de la agencia de viajes "
			+ "\n" + "Lo primero que haremos sera crear el lugar , vuelo, hotel y actividades del viaje"
			+ "\n" + "Recuerda que los codigos de estas caracteristicas tendras que agregarlos posteriormente al plan de viaje");
	
	private final String text;
	
	private Text(String text) {
		this.text=  text;
	}
	
	public String toString() {
		return text;
	}
	

}

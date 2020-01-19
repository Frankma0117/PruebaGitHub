package exceptions;

public class ExistenceDateOfActivityException extends Exception {
	
	public ExistenceDateOfActivityException() {
		super("Para poder asignar actividades al empleado debes haber asignado una fecha a tu viaje");
	}
}


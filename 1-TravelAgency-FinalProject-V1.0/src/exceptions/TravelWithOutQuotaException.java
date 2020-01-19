package exceptions;

public class TravelWithOutQuotaException extends Exception{
	public TravelWithOutQuotaException() {
		super("El cupo de este plan de viaje ya se llenó , por favor seleccione otro plan de viaje");
	}

}

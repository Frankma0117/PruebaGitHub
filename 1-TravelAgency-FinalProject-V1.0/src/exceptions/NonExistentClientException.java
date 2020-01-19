package exceptions;

public class NonExistentClientException extends Exception {
	
	public NonExistentClientException() {
		super("El codigo que intentas buscar no existe , intenta con otro codigo");
	}

}

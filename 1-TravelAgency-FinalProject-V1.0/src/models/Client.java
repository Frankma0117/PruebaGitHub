package models;

public class Client extends Person {
	
	private long cellPhoneNumber;
	
	public Client(String name , long identification , long cellPhoneNumber) {
		super(name,identification);
		this.cellPhoneNumber = cellPhoneNumber;
	}
	
	public long getCellPhoneNumber() {
		return cellPhoneNumber;
	}


}

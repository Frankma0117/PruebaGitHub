package models;
import enums.*;

public class Employment extends Person {
	
	private TypeActivity type;
	
	public Employment(String name , long identification , TypeActivity type ){
		super(name,identification);
		this.type = type;
	}

	public TypeActivity getType() {
		return type;
	}
}

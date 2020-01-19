package enums;

public enum GeneralMenu{
	GERENCY("Perfil del gerente"),
	CLIENT("Perfil del cliente"),
	EXIT("Salir del sistema");
	
	private final String text;
	private GeneralMenu(String text) {
		this.text= text;
	}
	
	public String toString() {
		return text;
	}
	

}

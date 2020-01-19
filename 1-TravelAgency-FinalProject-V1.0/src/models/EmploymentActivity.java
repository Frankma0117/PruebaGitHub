package models;
import exceptions.ExistenceDateOfActivityException;;

public class EmploymentActivity {
	
	private Activity activity;
	private Employment employment;
	private int code;
	
	public EmploymentActivity(Activity activity , Employment employment , int code) throws ExistenceDateOfActivityException{
		if(activity.getDayOfActivity() == null) {
			throw new  ExistenceDateOfActivityException();
		}
		
		this.activity = activity;
		this.employment = employment;
		this.code = code;

	}

	public Activity getActivity() {
		return activity;
	}

	public Employment getEmployment() {
		return employment;
	}

	public int getCode() {
		return code;
	}

	public String toString() {
		return("La actividad asignada al empleado " + employment.getName() + " con cedula " + employment.getIdentification() 
		+ " tiene las siguientes caracteristicas :" 
		+ "\n" +   "Nombre de la actividad " + activity.getName() 
		+ "\n" +   "Dia de la actividad " + activity.getDayOfActivity().toString()
		+ "\n" + "Lugar de la actividad " + activity.getPlace().getName()
		+ "\n" +   "Tipo de actividad " + activity.getTypeActivity()
		+ "\n" +   "Hora de inicio de la actividad " + activity.getTimeStartActivity() + "h"
		+ "\n" +   "Duracion de la actividad " + activity.getDurationActivity() + " horas");	
	}
	
	
	
	

}

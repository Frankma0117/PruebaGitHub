package views;
import javax.swing.JOptionPane;
import models.Activity;
import models.TripPlan;
import enums.*;
import models.EmploymentActivity;

public class View {
	
	public GeneralMenu showMenu() {
		return (GeneralMenu)JOptionPane.showInputDialog(null, "", "TITLE", JOptionPane.DEFAULT_OPTION, null, GeneralMenu.values(), GeneralMenu.values()[0]);
	}
	
	public ClientMenu showClientMenu() {
		return (ClientMenu)JOptionPane.showInputDialog(null, "", "TITLE", JOptionPane.DEFAULT_OPTION, null, ClientMenu.values(), ClientMenu.values()[0]);
	}
	
	public GerencyMenu showGerencyMenu() {
		return (GerencyMenu)JOptionPane.showInputDialog(null, "", "TITLE", JOptionPane.DEFAULT_OPTION, null, GerencyMenu.values(), GerencyMenu.values()[0]);
	}
	
	public String readString(String message){
		return JOptionPane.showInputDialog(null, message, "TITULO", JOptionPane.DEFAULT_OPTION);
	}
	
	public int readInt(String message){
		return Integer.parseInt(JOptionPane.showInputDialog(null, message, "TITULO", JOptionPane.DEFAULT_OPTION));
	}
	
	public long readLong(String message){
		return Long.parseLong(JOptionPane.showInputDialog(null, message, "TITULO", JOptionPane.DEFAULT_OPTION));
	}
	
	public double readDouble(String message){
		return Double.parseDouble(JOptionPane.showInputDialog(null, message, "TITULO", JOptionPane.DEFAULT_OPTION));
	}
	
	public double readEnum(String message){
		return Double.parseDouble(JOptionPane.showInputDialog(null, message, "TITULO", JOptionPane.DEFAULT_OPTION));
	}
	
	public TypeActivity readTypeActivity(String message){
		return (TypeActivity)JOptionPane.showInputDialog(null, message, "TITULO",JOptionPane.DEFAULT_OPTION,null, TypeActivity.values(), TypeActivity.values()[0]);
	}
	
	public FlyType readFlyType(String message){
		return (FlyType)JOptionPane.showInputDialog(null, message, "TITULO",JOptionPane.DEFAULT_OPTION,null, FlyType.values(), FlyType.values()[0]);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "TITLE", JOptionPane.DEFAULT_OPTION);
	}
	
	public void showMessageExceptions(String message) {
		JOptionPane.showMessageDialog(null, message, "TITLE", JOptionPane.CANCEL_OPTION);
	}
	
	public void showSheduleClient(String[][] message) {	
		String result = "";
				for(int indexi = 0; indexi < message.length;indexi++) {
					for(int indexj = 0; indexj < message[indexi].length;indexj++ ) {
						if(message[indexi][indexj] == null) {
							message[indexi][indexj] = "________Disponible________";
						}
						String formatLine = "%1$-30s ";	
						result +=  String.format(formatLine, message[indexi][indexj]);
						result+= "               "; 
					}
					result += "\n";
				}
				JOptionPane.showMessageDialog(null,result,"TITLE", JOptionPane.DEFAULT_OPTION);
	}
	
	public void showResultEmploymentActivities(EmploymentActivity[] message) { 
		String result = "";
		for(int index = 0; index < message.length; index ++) {
			if(message[index]!= null) {
				result +=  message[index] + "\n\n" ;
			}
		}JOptionPane.showMessageDialog(null,result,"TITLE", JOptionPane.DEFAULT_OPTION);
	}
	
	public void showResultTripPlans(TripPlan[] message) { 
		for(int index=0; index < message.length;index++){
			if(message[index]!= null)
		JOptionPane.showMessageDialog(null,message[index],"TITLE", JOptionPane.DEFAULT_OPTION);
		}
	}
	
	public void showActivities(Activity[] message) { 
		for(int index=0; index< message.length;index++){
			if(message[index]!= null)
		JOptionPane.showMessageDialog(null,message[index],"TITLE", JOptionPane.DEFAULT_OPTION);
		}
	}
	
	
	
	

}

abstract class Car{

	private String registrationPlate; //variable initialis�e par d�faut � null
	
	public abstract void run();//m�thode abstraite
	public void setRegistrationPlate(String registrationPlate){
			this.registrationPlate = registrationPlate;
	}
	
	public String getRegistrationPlate(){
			return registrationPlate;
	}
	
}
abstract class Car{

	private String registrationPlate; //variable initialisée par défaut à null
	
	public abstract void run();//méthode abstraite
	public void setRegistrationPlate(String registrationPlate){
			this.registrationPlate = registrationPlate;
	}
	
	public String getRegistrationPlate(){
			return registrationPlate;
	}
	
}
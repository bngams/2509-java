/*
compilation : javac *.java
ex�cution : java FastCar
*/

class FastCar extends Car{

	public FastCar(String rp){
			setRegistrationPlate(rp);//m�thode publique h�rit�e de Car
	}
	
	public void run(){
		System.out.println("je suis une voiture rapide d'immatriculation "+getRegistrationPlate() +" qui roule");
	}
	
	public void goFast(){
		System.out.println("je roule tres vite !!!");
	}
	
	public static void main(String[] args){
	  Car car = new FastCar("1676ZP13"); // polymorphisme  : FastCar IS-A (est un) Car 
	  car.run();
	  if(car instanceof FastCar){
		System.out.println("car est bien une instance de FastCar");
		}
	  
	  //on assigne l'objet r�f�renc� par car � la variable fastCar
	  FastCar fastCar = (FastCar) car; //on aurait pu v�rifier que car r�f�rence bien une instance FastCar en utilisant instanceof
	  fastCar.goFast();
	
	}

}
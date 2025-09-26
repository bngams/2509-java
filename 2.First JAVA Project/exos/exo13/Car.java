public class Car implements Drivable, Breakable{

	public void turnLeft() {
		System.out.println("tourne à gauche");
	}
	
	public void turnRight(){//le mot clé publique est ici obligatoire. On ne peut réduire la visibilité d'une méthode
		System.out.println("tourne à droite");
	}
	
	public void destroy(){
		System.out.println("BOUM");
	}
	
}
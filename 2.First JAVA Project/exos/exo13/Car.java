public class Car implements Drivable, Breakable{

	public void turnLeft() {
		System.out.println("tourne � gauche");
	}
	
	public void turnRight(){//le mot cl� publique est ici obligatoire. On ne peut r�duire la visibilit� d'une m�thode
		System.out.println("tourne � droite");
	}
	
	public void destroy(){
		System.out.println("BOUM");
	}
	
}
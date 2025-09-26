public class Test{

	public static void main(String[] args){
		Drivable car1 = new Car();
		//le compilateur connait uniquement les variables et leur type. on peut donc invoquer uniquement les méthodes
		//définies dans Drivable même si l'objet référencé est de type Car.
		car1.turnLeft();
		car1.turnRight();
		//si on veut invoquer destroy(), il faut caster.Ci-dessous un exemple de syntaxe raccourcie.
		((Breakable) car1).destroy(); // L'objet Car implémente l'interface Breakable il est (IS-A) donc Breakable
	
		Breakable car2 = new Car();
		Breakable glass1 = new Glass();
		
		Breakable[] breakables = new Breakable[3];//on assigne un tableau dont les éléments de type Breakable. On n'instancie en aucun cas l'interface Breakable
		breakables[0] = car2;
		breakables[1] = glass1;
		breakables[2] = (Breakable) car1;
		//ou
		//breakables[2] = (Car) car1; //Car IS-A Breakable donc une instance assignée à une var de type Car peut être assignée à une variable de type Breakable
		for(Breakable b : breakables) b.destroy(); //boucle for customisée
		
	}

}
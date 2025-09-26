package com.ws1.zoo;
//classe accessible que par les classes membres du package com.ws1.zoo

/*Question ? 
vous pouvez accéder à la classe Dog que depuis des classes membres du même package. par accéder, on entend :
-créer une variable de type Animal, instancier un objet de type Animal
-hériter de la classe Animal
-invoquer des méthodes (si leur modificateur d'accès le permet) sur une référence de type Animal

Donc depuis Test.main(), vous ne pouvez pas instancier la classe d'accessibilité de niveau package 
com.ws1.zoo Animal (membre du package com.ws1.zoo). Vous ne pouvez pas créer de variable de type Animal, ni invoquer des méthodes.
*/
class Animal {

	public Animal(){
		System.out.println("animal instancié");
	}
		
}
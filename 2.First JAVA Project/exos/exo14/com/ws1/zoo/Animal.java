package com.ws1.zoo;
//classe accessible que par les classes membres du package com.ws1.zoo

/*Question ? 
vous pouvez acc�der � la classe Dog que depuis des classes membres du m�me package. par acc�der, on entend :
-cr�er une variable de type Animal, instancier un objet de type Animal
-h�riter de la classe Animal
-invoquer des m�thodes (si leur modificateur d'acc�s le permet) sur une r�f�rence de type Animal

Donc depuis Test.main(), vous ne pouvez pas instancier la classe d'accessibilit� de niveau package 
com.ws1.zoo Animal (membre du package com.ws1.zoo). Vous ne pouvez pas cr�er de variable de type Animal, ni invoquer des m�thodes.
*/
class Animal {

	public Animal(){
		System.out.println("animal instanci�");
	}
		
}
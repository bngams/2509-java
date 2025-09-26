package com.ws1.zoo;
//classe accessible n'importe o� dans le programme
public class Dog extends Animal{ //Dog peut h�riter d'Animal(c'est-�-dire acc�der �) car Dog appartient au m�me package qu'Animal

	public Dog(){
		super();//invocation explicite du constructeur d'Animal. Si non explicitement invoqu�, le compilateur aurait ajout� cette instruction.
		System.out.println("chien instanci�");
	}
	
	public void bark(){
		System.out.println("Le chien aboie");
	}

}
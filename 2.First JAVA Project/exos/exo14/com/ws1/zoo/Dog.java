package com.ws1.zoo;
//classe accessible n'importe où dans le programme
public class Dog extends Animal{ //Dog peut hériter d'Animal(c'est-à-dire accéder à) car Dog appartient au même package qu'Animal

	public Dog(){
		super();//invocation explicite du constructeur d'Animal. Si non explicitement invoqué, le compilateur aurait ajouté cette instruction.
		System.out.println("chien instancié");
	}
	
	public void bark(){
		System.out.println("Le chien aboie");
	}

}
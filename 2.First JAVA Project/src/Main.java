import java.util.ArrayList; // utilisation de toute la classe
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // System = class
        // out = variable qui represente un objet


        // Types de variables
        int i; // declaration
        i = 1; // assignation

        int k = 2; // decla + assign

        // Types objets
        Integer j = 1;
        // j.compareTo(2) // X méthodes sur le type objet
        i = j; // cast => auto unboxing
        j = k; // cast => auto boxing


        String word = "A word";
        // char[] word = {"A", ...

        // tableau classique / initialisation taille fixe
        int[] arrayNumbers = {1, 2};
        // not possible: arrayNumbers[3] = 3;

        // on reste sur un tableau "primitif"
        Integer[] arrayNumbersBis = {1, 2};

        for (int l = 0; l < arrayNumbersBis.length; l++) {
            // ...
        }

        // Utiliser des collections
        ArrayList<Integer> collectionNumbers = new ArrayList<>();
        collectionNumbers.add(1);
        collectionNumbers.add(2);

        // for i classique
        for (int l = 0; l < collectionNumbers.size(); l++) {
            // ...
        }

        // foreach
        for(Integer n : collectionNumbers ) {
            System.out.println(n);
        }

        // iterators
        Iterator<Integer> iterator = collectionNumbers.iterator();
        while(iterator.hasNext()) {
            //...
        }

        // lambdas expressions => fonctions anonymes / a la volee
        collectionNumbers.forEach(n -> System.out.println(n));
        collectionNumbers.forEach(System.out::println);

        // streams => comme for / boucle pour parcourir mais sous forme de stream
        // streams => x fonctionnalités... ex: peek (exec une instruction pour chaque element ,
        // ex findFirst => s'arreter au premier
        collectionNumbers.stream().peek(System.out::println).findFirst();

        // Type ArrayList
        // new ArrayList<Integer> ou new ArrayList<> "le compilateur se répère au type de variable en amont"
        // ArrayList<Integer> collectionNumbersBis = new ArrayList<Integer>(List.of(arrayNumbersBis));
        ArrayList<Integer> collectionNumbersBis = new ArrayList<>(List.of(arrayNumbersBis));

        // List utilisé en tant que type de variable (typage de la variable)
        List<Integer> collectionNumbersOther = new ArrayList<>();

        // List n'est pas instanciable  => List = interface (comme une classe virtuelle)
        // List<Integer> collectionNumbersOther = new List<>();
    }
}
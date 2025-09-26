package fr.aelion.java;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambdas {

    /**
     * Commentaire JAVADOC
     * @param args
     */
    public static void main(String[] args) {

        // si traitement unique => dommage de créer une classe...
        // si traitement à ré-utiliser ds x fichiers => class CustomTask extends Runnable
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        new Thread(task).start();


        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        words.forEach(w -> System.out.println(w));
        words.forEach(System.out::println);


    }
}

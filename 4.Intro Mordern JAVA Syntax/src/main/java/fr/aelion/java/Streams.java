package fr.aelion.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        words.add("!!");

        // * facons de créer un stream
        // Stream.of(words)...
        // words.stream()

        // 1 stream => typage
        // Stream<String> str = words.stream();
        // var => type implicite (déduit par JAVA) => type inference
        // def du stream
        var str = words.stream()
                .parallel()
                .filter(w -> w.length() > 2)
                .map(w -> w.toUpperCase());

        // utilisation du stream (avec l'operation terminale collect)
        // List<String> newWords = str
        //         .collect(Collectors.toList());
        // newWords.forEach(System.out::println);

        // acc = "" + HELLO
        // acc = HELLO + WORD
        String sentence = str.reduce("", (acc, value) -> acc + ' ' + value);
        System.out.println(sentence);

    }

    // Programmation fonctionnelle => pas d'état stocké, aspect dynamique ou reactif...
    public static String computeSentence(List<String> words) {
        return words.stream()
                .filter(w -> w.length() > 2)
                .map(w -> w.toUpperCase())
                .reduce("", (acc, value) -> acc + ' ' + value);
    }
}

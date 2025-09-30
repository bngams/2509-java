package fr.aelion.java;

import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<Wizards> getWizards(){
        return List.of(
                new Wizards("Gryfindor","phoenix feather core","Half Blood","Male","Harry Potter"),
                new Wizards("Gryfindor","unicorn hair core","Pure Blood","Male","Ronald Wisely"),
                new Wizards("Gryfindor","dragon heart string core","Mud Blood","Female","Hermione Granger"),
                new Wizards("Slytherin","unicorn hair core","Pure Blood","Male","Draco Malfoy"),
                new Wizards("Ravenclaw","unicorn hair core","Pure Blood","Male","Cedric Diggory")

        );
    }

    public static void main(String[] args) {
        Optional<Wizards> wizard = Optional.of(getWizards().get(0));
        // Syntaxe moderne optionals
        Wizards w  = wizard.orElseThrow(NullPointerException::new);

        // Syntaxe equivalente en version classique (sans Optional)
        Wizards wB = getWizards().get(0);
        if(wB == null) {
            throw  new NullPointerException();
        }

        // Demo avec nullable
        Wizards wC = (Wizards) Optional.ofNullable(null)
                .orElseGet(() -> {
                    return getWizards().get(1);
                });
    }
}
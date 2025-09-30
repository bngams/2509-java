package fr.aelion.java.display.console;


import fr.aelion.java.data.entity.Contact;
import fr.aelion.java.data.repository.ContactRepositoryJpa;
import fr.aelion.java.data.service.ContactService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class AppConsole {

    public void run() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactsPU");
        EntityManager em = emf.createEntityManager();
        ContactService service = new ContactService(new ContactRepositoryJpa(em));
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("\n=== Contacts ===");
            System.out.println("1) Lister");
            System.out.println("2) Créer");
            System.out.println("3) Supprimer par id");
            System.out.println("4) Supprimer par nom+prénom");
            System.out.println("5) Rechercher par nom");
            System.out.println("0) Quitter");
            System.out.print("Choix: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    List<Contact> all = service.listAll();
                    all.forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("Nom: ");        String name = sc.nextLine();
                    System.out.print("Prénom: ");     String fn = sc.nextLine();
                    System.out.print("Téléphone: ");  String tel = sc.nextLine();
                    System.out.print("Email: ");      String email = sc.nextLine();
                    Contact c = service.create(name, fn, tel, email);
                    System.out.println("Créé: " + c);
                    break;
                case "3":
                    System.out.print("Id: ");
                    Integer id = Integer.valueOf(sc.nextLine());
                    service.deleteById(id);
                    System.out.println("Supprimé (si existant).");
                    break;
                case "4":
                    System.out.print("Nom: "); String n = sc.nextLine();
                    System.out.print("Prénom: "); String f = sc.nextLine();
                    int cnt = service.deleteByNameAndFirstName(n, f);
                    System.out.println("Supprimés: " + cnt);
                    break;
                case "5":
                    System.out.print("Nom (contient): ");
                    String q = sc.nextLine();
                    service.search(q).forEach(System.out::println);
                    break;
                case "0":
                    loop = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        em.close();
        emf.close();
    }
}

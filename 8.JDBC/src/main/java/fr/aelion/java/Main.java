package fr.aelion.java;

import fr.aelion.java.data.dal.ContactDAO;
import fr.aelion.java.data.entities.Contact;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ContactDAO cdao = new ContactDAO();
            List<Contact> contacts = cdao.findAll();
            contacts.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("KO");
        }
    }
}
package fr.aelion.java.data.repository;

import fr.aelion.java.data.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
    Contact save(Contact c);
    void deleteById(Integer id);
    int deleteByNameAndFirstName(String name, String firstName); // pour coller au TP
    Optional<Contact> findById(Integer id);
    List<Contact> findAll();
    List<Contact> searchByName(String nameLike);
}

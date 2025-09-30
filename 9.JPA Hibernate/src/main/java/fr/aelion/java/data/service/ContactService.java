package fr.aelion.java.data.service;

import fr.aelion.java.data.entity.Contact;
import fr.aelion.java.data.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

public class ContactService {
    private final ContactRepository repo;

    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public Contact create(String name, String firstName, String tel, String email) {
        return repo.save(new Contact(null, name, firstName, tel, email));
    }

    public boolean deleteById(Integer id) {
        repo.deleteById(id);
        return true;
    }

    public int deleteByNameAndFirstName(String name, String firstName) {
        return repo.deleteByNameAndFirstName(name, firstName);
    }

    public List<Contact> listAll() {
        return repo.findAll();
    }

    public Optional<Contact> get(Integer id) {
        return repo.findById(id);
    }

    public List<Contact> search(String nameLike) {
        return repo.searchByName(nameLike);
    }
}

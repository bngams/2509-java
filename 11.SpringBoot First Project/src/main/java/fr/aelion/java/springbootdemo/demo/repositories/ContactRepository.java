package fr.aelion.java.springbootdemo.demo.repositories;

import fr.aelion.java.springbootdemo.demo.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}

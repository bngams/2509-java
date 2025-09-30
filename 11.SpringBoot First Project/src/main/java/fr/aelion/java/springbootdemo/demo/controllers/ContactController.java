package fr.aelion.java.springbootdemo.demo.controllers;

import fr.aelion.java.springbootdemo.demo.entities.Contact;
import fr.aelion.java.springbootdemo.demo.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo/contacts")
public class ContactController {

    private ContactRepository contactRepo;

    @Autowired
    public ContactController(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping("")
    public Iterable<Contact> get() {
        return this.contactRepo.findAll();
    }
}

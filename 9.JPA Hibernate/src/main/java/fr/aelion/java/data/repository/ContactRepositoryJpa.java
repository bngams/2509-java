package fr.aelion.java.data.repository;

import fr.aelion.java.data.entity.Contact;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class ContactRepositoryJpa implements ContactRepository {
    private final EntityManager em;

    public ContactRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Contact save(Contact c) {
        em.persist(c); // save and get id
        return c;
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Contact ref = em.find(Contact.class, id);
            if (ref != null) em.remove(ref);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

    @Override
    public int deleteByNameAndFirstName(String name, String firstName) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            int updated = em.createQuery(
                            "DELETE FROM Contact c WHERE c.name = :n AND c.firstName = :f")
                    .setParameter("n", name)
                    .setParameter("f", firstName)
                    .executeUpdate();
            tx.commit();
            return updated;
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

    @Override
    public Optional<Contact> findById(Integer id) {
        return Optional.ofNullable(em.find(Contact.class, id));
    }

    @Override
    public List<Contact> findAll() {
        return em.createQuery("SELECT c FROM Contact c ORDER BY c.id", Contact.class)
                .getResultList();
    }

    @Override
    public List<Contact> searchByName(String nameLike) {
        return em.createQuery(
                        "SELECT c FROM Contact c WHERE LOWER(c.name) LIKE LOWER(:q) ORDER BY c.name",
                        Contact.class)
                .setParameter("q", "%" + nameLike + "%")
                .getResultList();
    }
}


package fr.aelion.java.data.dal;

import fr.aelion.java.data.entities.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDAO extends AbstractDAO<Contact> {

    public ContactDAO() throws Exception {
        super();
    }

    @Override
    public List<Contact> findAll() throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");

        List<Contact> contacts = new ArrayList<>();
        while (rs.next()) {
           contacts.add(new Contact(
                   rs.getLong("id"),
                   rs.getString("firstname"),
                   rs.getString("lastname"),
                   rs.getString("tel"),
                   rs.getString("email")
           ));
        }
        return contacts;
    }

    @Override
    public Optional<Contact> findById() {
        return Optional.empty();
    }
}

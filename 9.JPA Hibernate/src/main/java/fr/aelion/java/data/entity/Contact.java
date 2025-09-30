package fr.aelion.java.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lastname", nullable = false, length = 45)
    private String name; // correspond à lastname du TP JDBC

    @Column(name = "firstname", nullable = false, length = 45)
    private String firstName; // idem

    @Column(name = "tel", nullable = false, length = 16)
    private String tel;

    @Column(name = "email", nullable = false, length = 90)
    private String email;

}

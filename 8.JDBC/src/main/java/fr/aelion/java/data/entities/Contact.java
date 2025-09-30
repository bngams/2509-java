package fr.aelion.java.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Long id;
    private String firstname;
    private String lastname;
    private String tel;
    private String email;
}

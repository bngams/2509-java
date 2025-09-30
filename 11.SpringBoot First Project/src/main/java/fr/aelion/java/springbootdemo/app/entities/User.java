package fr.aelion.java.springbootdemo.app.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_email", columnNames = "email")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", nullable = false, length = 100)
    @NotBlank
    @JsonAlias({ "lName", "l_name" })
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 100)
    @NotBlank
    @JsonAlias({ "fName", "f_name" })
    private String firstName;

    @Column(name = "email", nullable = false, length = 255)
    @NotBlank
    @Email
    private String email;

    @Column(name = "phone_number", nullable = false, length = 20)
    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String phoneNumber;
}

package fr.aelion.java.springbootdemo.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    @NotBlank
    private String title;

    @Column(length = 255)
    private String description;

    @Column(name = "operation_mode", length = 20, nullable = false)
    @NotBlank
    @Pattern(regexp = "AGILE|FIXED_PRICE", message = "operationMode must be AGILE or FIXED_PRICE")
    private String operationMode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private User manager;

    @Column(name = "budget_eur", nullable = false)
    @Min(0)
    private Integer budgetEur;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "estimated_days", nullable = false)
    @Min(0)
    private Integer estimatedDays;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

}

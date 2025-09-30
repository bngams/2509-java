package fr.aelion.java.springbootdemo.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks", uniqueConstraints = {
        @UniqueConstraint(name = "uq_tasks_project_tracking", columnNames = {"project_id", "tracking_number"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_number", length = 30, nullable = false)
    @NotBlank
    private String trackingNumber;

    @Column(name = "hourly_rate_eur", nullable = false)
    @Min(0)
    private Integer hourlyRateEur;

    @Column(name = "duration_hours", nullable = false)
    @Min(0)
    private Integer durationHours;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    // @JsonIgnore // ignore or get id only for deserialization
    @JsonManagedReference // avoid nested objects serialization / deserialization
    private Project project;

}

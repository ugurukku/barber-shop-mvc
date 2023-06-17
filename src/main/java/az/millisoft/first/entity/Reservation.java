package az.millisoft.first.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String phone;

    private String reservationTime;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Branch branch;

    private LocalDate reservationDate;

    private Integer people;

    private String comment;


}

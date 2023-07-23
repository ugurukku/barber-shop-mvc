package az.millisoft.first.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}

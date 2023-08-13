package aabir.example.securityjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "userName")
    private String userName;

    private String password;

    private boolean active;

    private String roles;
}

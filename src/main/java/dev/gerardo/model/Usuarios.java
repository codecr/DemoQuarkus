package dev.gerardo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Usuarios extends PanacheEntityBase {
    @Id
    @GeneratedValue
    public Integer id;

    public String nombre;

    public String email;
}

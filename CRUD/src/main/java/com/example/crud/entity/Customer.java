package com.example.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar en blanco")
    private String lastName;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Email(message = "El formato del correo electrónico debe ser válido")
    private String email;

    public Customer() {


    }

    public Customer(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

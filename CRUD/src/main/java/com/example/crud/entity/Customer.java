package com.example.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
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

    //Validaciones sobre un Array
    // @Valid: Le dice a Spring que valide cada elemento dentro de la lista.
    // @NotEmpty: La lista no puede ser nula ni estar vacía.
    // @Size: La lista debe contener entre 1 y 3 números de teléfono.

    @NotEmpty(message = "Debe proporcionar al menos un número de teléfono")
    @Size(min = 1, max = 3, message = "Debe proporcionar entre 1 y 3 números de teléfono")
    @Valid
    @ElementCollection
    @CollectionTable(name = "customer_phone_numbers", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone_number")
    private List<PhoneNumber> phoneNumbers;


    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, String email, List<PhoneNumber> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }
}

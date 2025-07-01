package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//con @Entity sabe que se mapea como una tabla en bd
@Entity
//con @Table puedes definir el nombre con el que se va a crear la tabla
@Table(name = "customers")
public class Customer {
    @Id
    //con @GenerateValue se define como se va a llenar el Id en la bd
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    //con @Column se crea la columna con el nombre
    //@Column(name = "nombre")
   private String firstName;
   private String lastName;
   //unique que debe ser unico y nullable que obligado debe tener un valor
   @Column(unique = true, nullable = false)
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

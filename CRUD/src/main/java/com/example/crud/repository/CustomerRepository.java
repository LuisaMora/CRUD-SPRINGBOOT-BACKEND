package com.example.crud.repository;

import com.example.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//Recibe dos parametros de entrada la clase entidad a la que se le debe hacer el crud y el tipo
//JPA tiene todos los metodos crud
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

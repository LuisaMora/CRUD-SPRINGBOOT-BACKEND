package com.example.crud.repository;

import com.example.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Recibe dos parametros de entrada la clase entidad a la que se le debe hacer el crud y el tipo
//JPA tiene todos los metodos crud
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

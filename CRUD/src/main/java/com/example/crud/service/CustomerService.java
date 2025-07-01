package com.example.crud.service;

import com.example.crud.entity.Customer;
import java.util.List;

//Se definen los metodos que va a tener este customer
public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
    void deleteById(Integer id);
    Customer update(Customer customer);
}

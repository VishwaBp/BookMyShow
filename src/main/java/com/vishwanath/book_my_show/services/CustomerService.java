package com.vishwanath.book_my_show.services;


import com.vishwanath.book_my_show.models.Customer;
import com.vishwanath.book_my_show.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer signUp(String name, String email, String password) {
        System.out.println("Service layer called for creating customer.");

//        BCryptPasswordEncoder()


        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setBookings(new ArrayList<>());

        // Call the repository layer and try to save that to DB.
        customerRepository.save(customer);

        return customer;
    }

}

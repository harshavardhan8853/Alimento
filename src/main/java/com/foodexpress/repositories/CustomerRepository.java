package com.foodexpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodexpress.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

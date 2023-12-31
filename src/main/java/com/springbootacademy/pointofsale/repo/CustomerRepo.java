package com.springbootacademy.pointofsale.repo;

import com.springbootacademy.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByNic(String nic);


    List<Customer> findAllByCustomerNameAndActiveStatus(String name, Boolean activeStatus);
}

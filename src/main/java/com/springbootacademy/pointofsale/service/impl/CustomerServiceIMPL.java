package com.springbootacademy.pointofsale.service.impl;
import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestCustomerUpdateDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.repo.CustomerRepo;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.getContactNumber(),
                customerDTO.isActiveStatus()
        );

        if(!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
            return customer.getCustomerName()+" Saved";
        }else{
            throw new DuplicateKeyException("Customer already exists.");
        }

    }

    @Override
    public String updateCustomer(RequestCustomerUpdateDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())){
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customerRepo.save(customer);

            return "saved- updated";
        }
        else {
            throw new RuntimeException("no customer found ");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getNic(),
                    customer.get().getContactNumber(),
                    customer.get().isActiveStatus()

            );
            return customerDTO;
        }else{
            throw new RuntimeException("Not Found");
        }


        // return null;
    }
}

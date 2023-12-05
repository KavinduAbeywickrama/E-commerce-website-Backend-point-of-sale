package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestCustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer (CustomerDTO customerDTO);

    String updateCustomer(RequestCustomerUpdateDTO customerDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    CustomerDTO getCustomerByNic(String nic);

    List<CustomerDTO> getAllCustomersByNameAndState(String name);


}

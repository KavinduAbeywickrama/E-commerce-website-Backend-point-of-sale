package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestCustomerUpdateDTO;

public interface CustomerService {
    public String saveCustomer (CustomerDTO customerDTO);

    String updateCustomer(RequestCustomerUpdateDTO customerDTO);

    CustomerDTO getCustomerById(int customerId);
}

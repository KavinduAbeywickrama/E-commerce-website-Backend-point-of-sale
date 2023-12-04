package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestCustomerUpdateDTO;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
@ResponseBody
public class CustomerController {

    @Autowired
    private CustomerService customerService;

     @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody RequestCustomerUpdateDTO customerDTO){
         String updated = customerService.updateCustomer(customerDTO);
         return updated;

    }

    @GetMapping(path = "/get-by-id", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }


}

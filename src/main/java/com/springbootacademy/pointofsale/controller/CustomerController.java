package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestCustomerUpdateDTO;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/get-all")
    public List<CustomerDTO> getAllCustomers(){
         List<CustomerDTO> allCustomers = customerService.getAllCustomers();
         return allCustomers;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(path = "/get-by-nic", params = "nic")
    public CustomerDTO getCustomerByNic(@RequestParam(value = "nic") String nic){
        CustomerDTO customerDTO = customerService.getCustomerByNic(nic);
        return customerDTO;
    }

    @GetMapping(path = "/get-all-customer-active-by-name-and-status/{name}")
    public List<CustomerDTO> getAllCustomerByStateAndName(@PathVariable(value = "name") String name){
         List<CustomerDTO> allCustomers = customerService.getAllCustomersByNameAndState(name);
         return allCustomers;
    }

}

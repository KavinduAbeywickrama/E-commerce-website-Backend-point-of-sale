package com.springbootacademy.pointofsale.service.impl;
import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestCustomerUpdateDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.repo.CustomerRepo;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(

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
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomer = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer: getCustomer ) {

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveStatus()
            );
            customerDTOList.add(customerDTO);

            
        }return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "delete success";
        }else {
            System.out.println("user not exist");
        }
        return null;
    }

    @Override
    public CustomerDTO getCustomerByNic(String nic) {
        Optional<Customer> customer = customerRepo.findByNic(nic);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(

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

    }

    @Override
    public List<CustomerDTO> getAllCustomersByNameAndState(String name) {
        List<Customer> getCustomer = customerRepo.findAllByCustomerNameAndActiveStatus(name,true);
        System.out.println("Customers found: " + customerRepo.findAllByCustomerNameAndActiveStatus(name,true));
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer: getCustomer){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveStatus()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}

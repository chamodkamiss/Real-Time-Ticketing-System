//package com.example.ticketingSystem.controller.service;
//
//import com.example.ticketingSystem.controller.dto.CustomerDto;
//import com.example.ticketingSystem.controller.entity.Customer;
//import com.example.ticketingSystem.controller.repo.CustomerRepo;
//import jakarta.transaction.Transactional;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class CustomerService {
//    @Autowired
//    private CustomerRepo customerRepo;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public List<CustomerDto> getAllCustomers()
//    {
//        List <Customer>  customerList = customerRepo.findAll();
//        return modelMapper.map(customerList , new TypeToken<List<CustomerDto>>(){}.getType());
//    }
//
//    public CustomerDto saveCustomer(CustomerDto customerDto)
//    {
//        customerRepo.save(modelMapper.map(customerDto, Customer.class));
//        return customerDto;
//    }
//
//
//}

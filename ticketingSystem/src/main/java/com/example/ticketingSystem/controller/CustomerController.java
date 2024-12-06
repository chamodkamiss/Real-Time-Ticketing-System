//package com.example.ticketingSystem.controller;
//
//import com.example.ticketingSystem.controller.dto.CustomerDto;
//import com.example.ticketingSystem.controller.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping("/getCustomers")
//    public List<CustomerDto> getCustomers()
//    {
//        return customerService.getAllCustomers();
//    }
//
//    @PostMapping("/saveCustomer")
//    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto)
//    {
//        return customerService.saveCustomer(customerDto);
//    }
//
//}

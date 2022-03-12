package com.cs527.web.controller;

import com.cs527.web.service.CustomerService;
import com.cs527.web.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public List<Customer> getCustomerList(){
        logger.info("getCustomerList");
        return customerService.getList();
    }
}
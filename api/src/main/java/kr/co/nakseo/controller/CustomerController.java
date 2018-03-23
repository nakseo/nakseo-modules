package kr.co.nakseo.controller;

import kr.co.nakseo.model.Customer;
import kr.co.nakseo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        log.debug("\n name : {} \n email : {}", customer.getName(), customer.getEmail());

        try {
            Customer save = customerService.addCustomer(customer);
            return new ResponseEntity<>(save, HttpStatus.CREATED);

        } catch (Exception e) {
            log.error("{}", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

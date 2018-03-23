package kr.co.nakseo.service.impl;

import kr.co.nakseo.dao.CustomerRepository;
import kr.co.nakseo.model.Customer;
import kr.co.nakseo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
}

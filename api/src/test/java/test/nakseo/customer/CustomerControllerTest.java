package test.nakseo.customer;

import kr.co.nakseo.ApiApplication;
import kr.co.nakseo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiApplication.class)
public class CustomerControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setName("JEEWOON JANG");
        customer.setEmail("mango.nakseo@gmail.com");

        ResponseEntity<String> response = this.testRestTemplate.postForEntity("/customer/add", customer, String.class);
        log.debug("\n {}", response);

    }

}

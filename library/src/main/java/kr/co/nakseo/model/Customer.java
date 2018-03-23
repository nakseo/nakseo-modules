package kr.co.nakseo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    String name;
    String email;
    Date date;

}

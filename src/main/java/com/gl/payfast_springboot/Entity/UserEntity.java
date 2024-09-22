package com.gl.payfast_springboot.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_entity")
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private long contact_number;
    private String address;
    private int pin;

}

package com.EmergencyLocator.User.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long age;
    private Long phone;
    private String email;
    private String password;
    private String bloodGroup;
    private Long emergencyContact;
    private Date createdAt;
}

package com.springRest.model;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Data
@Table(name="employees")
public class Employee {
    @Id
    @SequenceGenerator(
            name="employeeId",
            sequenceName = "employeeId",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "employeeId",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @Column(name="first_name",nullable=false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

}

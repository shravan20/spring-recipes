package com.example.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee  implements Serializable  {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String            firstName;

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String            lastName;

    @OneToMany(orphanRemoval = true, mappedBy = "employee")
    private Set<Account> accounts;


}

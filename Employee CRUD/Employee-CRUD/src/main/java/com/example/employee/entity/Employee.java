/* (C)2021 */
package com.example.employee.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import com.example.employee.commons.dto.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee extends AuditModel implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;

    @Column(name = "AGE", nullable = false)
    @Min(value = 14)
    private Long age;

    @Column(name = "salary", nullable = false)
    @Min(value = 1000)
    private Long salary;

    @Column(name="EMAIL", unique = true, nullable = false)
    @Email
    private String email;

    @OneToMany(orphanRemoval = true, mappedBy = "employee")
    private Set<Account> accounts;
}

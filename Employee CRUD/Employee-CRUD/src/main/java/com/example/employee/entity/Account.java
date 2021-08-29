/* (C)2021 */
package com.example.employee.entity;

import com.example.employee.commons.dto.AuditModel;
import com.example.employee.enums.AccountType;
import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Account")
public class Account extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ACC_NO", unique = false, nullable = false, length = 100)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccountType type;
}

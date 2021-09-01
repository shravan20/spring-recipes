/* (C)2021 */
package com.example.employee.repository;

import com.example.employee.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository
	extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
}

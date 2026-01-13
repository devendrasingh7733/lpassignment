package com.api.lp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lp.model.LoanAccount;

@Repository
public interface LoanAccountRepo extends JpaRepository<LoanAccount, Long> {

}

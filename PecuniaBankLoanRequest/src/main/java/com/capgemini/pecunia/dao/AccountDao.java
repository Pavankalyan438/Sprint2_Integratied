package com.capgemini.pecunia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.AccountDetails;
@Repository
public interface AccountDao extends JpaRepository<AccountDetails, String> {

}

package com.masai.studentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.studentManagement.module.Address;

public interface AddressDAO extends JpaRepository<Address, Integer>{

}

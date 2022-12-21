package com.masai.studentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.studentManagement.module.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer> {

}

package com.jsp.boot_crud.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.boot_crud.dto.EmployeeDto;

public interface Repository extends JpaRepository<EmployeeDto, Integer> {

}

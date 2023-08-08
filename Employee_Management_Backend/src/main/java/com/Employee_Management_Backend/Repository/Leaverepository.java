package com.Employee_Management_Backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.Leaveentity;
@Repository
public interface Leaverepository extends JpaRepository<Leaveentity, Integer>{

	List<Leaveentity> findByEmployee(EmployeeEntity employee);
	
	
}

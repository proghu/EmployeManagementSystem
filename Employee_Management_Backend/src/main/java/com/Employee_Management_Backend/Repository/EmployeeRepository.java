package com.Employee_Management_Backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.EmployeeQualifications;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	
	
	@Query(value = " select*from Employee_Tables where First_name like %?1%",nativeQuery = true)
	List<EmployeeEntity> getEmployeeByfirstName(String firstName);

}

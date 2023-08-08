package com.Employee_Management_Backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.JobDepartment;

@Repository
public interface JobDepartmentRepository extends JpaRepository<JobDepartment, Integer>{

	@Query(value = " select*from job_department where job_name like %?1%",nativeQuery = true)
	List<JobDepartment> getDepartmentByjobName(String jobName);
	
}

package com.Employee_Management_Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee_Management_Backend.Entity.EmployeeQualifications;

@Repository
public interface QualificationsRepository extends JpaRepository<EmployeeQualifications, Integer>{

}

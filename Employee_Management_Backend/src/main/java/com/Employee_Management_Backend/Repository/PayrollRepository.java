package com.Employee_Management_Backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee_Management_Backend.Entity.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Integer>{

}

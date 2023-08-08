package com.Employee_Management_Backend.Services;

import java.util.List;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.EmployeeQualifications;
import com.Employee_Management_Backend.Entity.Leaveentity;
import com.Employee_Management_Backend.Entity.Payroll;

public interface EmployeeServices {
	
	List<EmployeeEntity> getAllEmployees();
	EmployeeEntity getEmployeeById(int empId);
	EmployeeEntity createEmployee(EmployeeEntity employee);
	EmployeeEntity updateEmployee(int empId, EmployeeEntity employee);
    void deleteEmployee(int empId);
    

   List<EmployeeQualifications> getEmployeeQualifications(int empId);
   
   List<Payroll> getEmployeePayrolls(int empId);
   
   List<EmployeeEntity> getEmployeeByfirstName(String firstName);
   
   


}

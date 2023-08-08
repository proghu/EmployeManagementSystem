package com.Employee_Management_Backend.ServiceImplementions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.EmployeeQualifications;
import com.Employee_Management_Backend.Entity.Leaveentity;
import com.Employee_Management_Backend.Entity.Payroll;
import com.Employee_Management_Backend.Repository.EmployeeRepository;
import com.Employee_Management_Backend.Services.EmployeeServices;

@Service
public class EmployeeImplementation  implements EmployeeServices{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		
		 return employeeRepository.save(employee);
	}
	

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		 Optional<EmployeeEntity> employee = employeeRepository.findById(empId);
	        return employee.orElse(null);
	}

	

	@Override
	public EmployeeEntity updateEmployee(int empId, EmployeeEntity employee) {
		
		// TODO Auto-generated method stub
		employee.setEmpId(empId);
		
        return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		
		employeeRepository.deleteById(empId);
	}


	@Override
	public List<EmployeeQualifications> getEmployeeQualifications(int empId) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);
		    if (employee != null) {
		        return employee.getQualifications();
		    }
		    return null;
	}


	public List<Payroll> getEmployeePayrolls(int empId) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);
	    if (employee != null) {
	        return employee.getPayrolls();
	    }
	    return null;
		
		
	}


	@Override
	public List<EmployeeEntity> getEmployeeByfirstName(String firstName) {
		// TODO Auto-generated method stub
		
		return employeeRepository.getEmployeeByfirstName(firstName);
	}


}

package com.Employee_Management_Backend.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.EmployeeQualifications;
import com.Employee_Management_Backend.Entity.Payroll;
import com.Employee_Management_Backend.Repository.EmployeeRepository;
import com.Employee_Management_Backend.Services.EmployeeServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emplyee_management/employees")
public class EmployeeController {
	

	
	  @Autowired
	private EmployeeServices employeeServices;
	  
	  @Autowired
	private EmployeeRepository employeeRepository;
	  
	  @PostMapping("/addEmployee")
	    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeEntity employee) {
		  
	    	EmployeeEntity createdEmployee = employeeServices.createEmployee(employee);
	        
			if(createdEmployee!=null) {
				return new ResponseEntity<EmployeeEntity> (createdEmployee,HttpStatus.CREATED);
			}else{
				return new ResponseEntity<String> ("All values Should be Valid Formation!!!!",HttpStatus.BAD_REQUEST);
			}
	        
	    }

	    @GetMapping("/emplyeesLists")
	    public ResponseEntity<?> getAllEmployees(){
	    	
	      
	        
	        if(this.employeeServices.getAllEmployees().size()>0)
			{
				return new ResponseEntity<List<EmployeeEntity>>(this.employeeServices.getAllEmployees(),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("NO Details Found",HttpStatus.NOT_FOUND);	
			}
	    }

	    @GetMapping("/get/{empId}")
	    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable int empId) {
	    	
	    	EmployeeEntity employee = employeeServices.getEmployeeById(empId);
	        if (employee == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }
	    
	    @GetMapping("/get/{empId}/qualifications")
	    public ResponseEntity<List<EmployeeQualifications>> getEmployeeQualifications(@PathVariable int empId) {
	    	
	        List<EmployeeQualifications> qualifications = employeeServices.getEmployeeQualifications(empId);
	        if (qualifications != null) {
	            return new ResponseEntity<>(qualifications, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	    
	    
	    @GetMapping("/get/{empId}/payrolls")
	    public ResponseEntity<List<Payroll>> getEmployeePayrolls(@PathVariable int empId) {
	        List<Payroll> payrolls = employeeServices.getEmployeePayrolls(empId);
	        if (payrolls != null) {
	            return new ResponseEntity<>(payrolls, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    
	    
	    @PutMapping("/update/{empId}")
	    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable int empId,@Valid @RequestBody EmployeeEntity employee) {
	    	EmployeeEntity updatedEmployee = employeeServices.updateEmployee(empId, employee);
	        if (updatedEmployee == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{empId}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable int empId) {
	        employeeServices.deleteEmployee(empId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    
	    @GetMapping("/search/employee/{firstName}")
	    public List<EmployeeEntity> getEmployeeByfirstName(@PathVariable String firstName) {
			
			// TODO Auto-generated method stub
			
	    	return employeeServices.getEmployeeByfirstName(firstName);
		}
	    
	    
	    
	    
	    
	    
	}


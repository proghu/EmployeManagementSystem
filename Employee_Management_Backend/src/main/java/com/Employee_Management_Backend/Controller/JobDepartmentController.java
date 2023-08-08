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
import com.Employee_Management_Backend.Entity.JobDepartment;
import com.Employee_Management_Backend.Entity.SalaryBonusEntity;
import com.Employee_Management_Backend.Repository.JobDepartmentRepository;
import com.Employee_Management_Backend.Services.JobDepartmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emplyee_management/employees/departments")
public class JobDepartmentController {
	
	@Autowired
	private JobDepartmentService jobDepartmentService;
	@Autowired
	private JobDepartmentRepository jobDepartmentRepository;
	
	
	 @PostMapping("/addJobDepartments")
	    public ResponseEntity<?> createJobDepartment(@Valid @RequestBody JobDepartment jobDepartment) {
		 
	        JobDepartment createdJobDepartment = jobDepartmentService.createJobDepartment(jobDepartment);
	        if(createdJobDepartment!=null) {
	        return new ResponseEntity<JobDepartment>(createdJobDepartment, HttpStatus.CREATED);
	        }else {
	        	return new ResponseEntity<String>("All values Should be Valid Formation!!!!",HttpStatus.BAD_REQUEST);
	        }
	    }
	
	
	 @GetMapping("/ListDepartments")
	    public ResponseEntity<List<JobDepartment>> getAllJobDepartments() {
	        List<JobDepartment> jobDepartments = jobDepartmentService.getAllJobDepartments();
	        
	        if(jobDepartments == null) {
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }else {
	        	 return new ResponseEntity<>(jobDepartments, HttpStatus.OK);
	        }
	       
	    }
	 
	 @GetMapping("/get/{jobId}")
	    public ResponseEntity<JobDepartment> getJobDepartmentById(@PathVariable int jobId) {
		 
	        JobDepartment jobDepartment = jobDepartmentService.getJobDepartmentById(jobId);
	        if (jobDepartment != null) {
	            return new ResponseEntity<>(jobDepartment, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
	 @GetMapping("/get/{jobId}/salary_bonuses")
	    public ResponseEntity<List<SalaryBonusEntity>> getSalaryBonusesByJobDepartmentId(@PathVariable int jobId) {
		 
	        List<SalaryBonusEntity> salaryBonuses = jobDepartmentService.getSalaryBonusesByJobDepartmentId(jobId);
	        if (salaryBonuses != null) {
	            return new ResponseEntity<>(salaryBonuses, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
	

	    @PutMapping("/update/{jobId}")
	    public ResponseEntity<JobDepartment> updateJobDepartment(@PathVariable int jobId,
	            @Valid @RequestBody JobDepartment jobDepartment) {
	    	
	        JobDepartment updatedJobDepartment = jobDepartmentService.updateJobDepartment(jobId, jobDepartment);
	        if (updatedJobDepartment != null) {
	            return new ResponseEntity<>(updatedJobDepartment, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @DeleteMapping("/delete/{jobId}")
	    public ResponseEntity<Void> deleteJobDepartment(@PathVariable int jobId) {
	        jobDepartmentService.deleteJobDepartment(jobId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    
	    
	    @GetMapping("/search/jobDepartment/{jobName}")
	    public List<JobDepartment> getEmployeeByfirstName(@PathVariable String jobName) {
			
			// TODO Auto-generated method stub
			
	    	return jobDepartmentService.getDepartmentByjobName(jobName);
		}

}

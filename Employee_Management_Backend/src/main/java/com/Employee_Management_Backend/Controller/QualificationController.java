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
import com.Employee_Management_Backend.Exceptions.ResourceNotFoundException;
import com.Employee_Management_Backend.Repository.EmployeeRepository;
import com.Employee_Management_Backend.Repository.QualificationsRepository;
import com.Employee_Management_Backend.Services.QualificationsServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emplyee_management/employees/qualifications")
public class QualificationController {
	
	@Autowired
	private QualificationsServices qualificationsServices;
	@Autowired
	private QualificationsRepository qualificationsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	 	@PostMapping("/addQualifications")
	    public ResponseEntity<?> createQualification(@Valid @RequestBody EmployeeQualifications qualification) {

	 		
	 		EmployeeQualifications createdQualification = qualificationsServices.createQualification(qualification);
	 	    
	 	    if (createdQualification != null) {
	 	        return new ResponseEntity<>(createdQualification, HttpStatus.CREATED);
	 	    } else {
	 	        return new ResponseEntity<>("Failed to create qualification", HttpStatus.INTERNAL_SERVER_ERROR);
	 	    }
	    }
	
	
	 	@GetMapping("/QualificationsLists")
	    public ResponseEntity<?> getAllQualifications() {
	 		
	 		 if(this.qualificationsServices.getAllQualifications().size()>0)
				{
					return new ResponseEntity<List<EmployeeQualifications>>(this.qualificationsServices.getAllQualifications(),HttpStatus.OK);
				}
				else
				{
				    return new ResponseEntity<String>("NO Details Found",HttpStatus.NOT_FOUND);	
				}
	 
	    }
	 	
	 	
	 	 @GetMapping("/get/{qualificationId}")
	     public ResponseEntity<EmployeeQualifications> getQualificationById(@PathVariable int qualificationId) {
	 		EmployeeQualifications qualification = qualificationsServices.getQualificationById(qualificationId);
	         if (qualification != null) {
	             return new ResponseEntity<>(qualification, HttpStatus.OK);
	         } else {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         }
	     }
	 	 
	 	 
	 	 
	 	 @PutMapping("/update/{qualificationId}")
	     public ResponseEntity<EmployeeQualifications> updateQualification(@PathVariable int qualificationId, @Valid @RequestBody EmployeeQualifications qualification) {
	 		
	 		 
	 		 EmployeeQualifications updatedQualification = qualificationsServices.updateQualification(qualificationId, qualification);
	         if (updatedQualification != null) {
	             return new ResponseEntity<>(updatedQualification, HttpStatus.OK);
	         } else {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         }
	         
	         
	 
	     }
	 	 
	 	 @DeleteMapping("/delete/{qualificationId}")
	     public ResponseEntity<Void> deleteQualification(@PathVariable int qualificationId) {
	         qualificationsServices.deleteQualification(qualificationId);
	         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     }

}
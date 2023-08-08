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

import com.Employee_Management_Backend.Entity.SalaryBonusEntity;
import com.Employee_Management_Backend.Repository.SalaryBonusRepository;
import com.Employee_Management_Backend.Services.SalaryBonusService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emplyee_management/employees/salary_bonuses")
public class SalaryBonusController {
	
	@Autowired
	private SalaryBonusService salaryBonusService;
	
	@Autowired
	private SalaryBonusRepository salaryBonusRepository;
	
	
	
	 @PostMapping("/add_salary_bonuses")
	    public ResponseEntity<?> createSalaryBonus(@Valid @RequestBody SalaryBonusEntity salaryBonus) {
		 
		 SalaryBonusEntity createdSalaryBonus = salaryBonusService.createSalaryBonus(salaryBonus);
	        
	        if(createdSalaryBonus!=null) {
	        	 return new ResponseEntity<SalaryBonusEntity>(createdSalaryBonus, HttpStatus.CREATED);
			}else{
				return new ResponseEntity<String> ("All values Should be Valid Formation!!!!",HttpStatus.BAD_REQUEST);
			}
	    }
	
	
	 @GetMapping("/salary_bonuses_list")
	    public ResponseEntity<?> getAllSalaryBonuses() {
	        
	        if(this.salaryBonusService.getAllSalaryBonuses().size()>0)
			{
				return new ResponseEntity<List<SalaryBonusEntity>>(this.salaryBonusService.getAllSalaryBonuses(),HttpStatus.OK);
			}
			else
			{
			    return new ResponseEntity<String>("NO Details Found",HttpStatus.NOT_FOUND);	
			}
	    }

	 
	 

	    @GetMapping("/get/{id}")
	    public ResponseEntity<SalaryBonusEntity> getSalaryBonusById(@PathVariable("id") int salaryId) {
	    	
	    	SalaryBonusEntity salaryBonus = salaryBonusService.getSalaryBonusById(salaryId);
	        
	         if (salaryBonus != null) {
	        	 return new ResponseEntity<>(salaryBonus, HttpStatus.OK);
	  	       
	         } else {
	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         }
	        
	    }
	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> updateSalaryBonus(@PathVariable("id") int salaryId, @Valid @RequestBody SalaryBonusEntity salaryBonus) {
	        
	    	
	    	SalaryBonusEntity updatedSalaryBonus = salaryBonusService.updateSalaryBonus(salaryId, salaryBonus);
	      
	        
	        if (updatedSalaryBonus != null) {
	        	  return new ResponseEntity<SalaryBonusEntity>(updatedSalaryBonus, HttpStatus.OK);
	         } else {
	        	 return new ResponseEntity<String> ("All values Should be Valid Formation!!!!",HttpStatus.BAD_REQUEST);
	         }
	        
	    }
	    
	    
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteSalaryBonus(@PathVariable("id") int salaryId) {
	        salaryBonusService.deleteSalaryBonus(salaryId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}

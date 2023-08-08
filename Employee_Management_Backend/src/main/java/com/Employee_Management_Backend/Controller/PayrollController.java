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

import com.Employee_Management_Backend.Entity.Payroll;
import com.Employee_Management_Backend.Repository.PayrollRepository;
import com.Employee_Management_Backend.Services.PayrollService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emplyee_management/employees/payrolls")
public class PayrollController {
	
	@Autowired
	private PayrollService payrollService;
	
	@Autowired
	private PayrollRepository payrollRepository;
	
	 @PostMapping("/add_payroll")
	    public ResponseEntity<?> createPayroll(@Valid @RequestBody Payroll payroll) {
		 
	        Payroll createdPayroll = payrollService.createPayroll(payroll);
	        
	        
	        if(createdPayroll!=null) {
	        	  return new ResponseEntity<Payroll>(createdPayroll, HttpStatus.CREATED);
			}else{
				return new ResponseEntity<String> ("All values Should be Valid Formation!!!!",HttpStatus.BAD_REQUEST);
			}
	    }
	 
	 
	    @GetMapping("/payrolls_list")
	    public ResponseEntity<?> getAllPayrolls() {
	    	
	    
	        
	        if(this.payrollService.getAllPayrolls().size()>0)
			{
				return new ResponseEntity<List<Payroll>>(this.payrollService.getAllPayrolls(),HttpStatus.OK);
			}
			else
			{
			    return new ResponseEntity<String>("NO Details Found",HttpStatus.NOT_FOUND);	
			}
	    }


	    @GetMapping("/get/{id}")
	    public ResponseEntity<Payroll> getPayrollById(@PathVariable("id") int payrollId) {
	    	
	        Payroll payroll = payrollService.getPayrollById(payrollId);
	        
	        if (payroll != null) {
	        	 return new ResponseEntity<>(payroll, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Payroll> updatePayroll(@PathVariable("id") int payrollId, @Valid @RequestBody Payroll payrollDetails) {
	        
	    	Payroll updatedPayroll = payrollService.updatePayroll(payrollId, payrollDetails);
	        
	        if (updatedPayroll != null) {
	        	 return new ResponseEntity<>(updatedPayroll, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deletePayroll(@PathVariable("id") int payrollId) {
	    	
	        payrollService.deletePayroll(payrollId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
	

}

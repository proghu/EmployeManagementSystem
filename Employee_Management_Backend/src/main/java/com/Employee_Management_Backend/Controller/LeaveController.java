package com.Employee_Management_Backend.Controller;

import java.util.List;

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

import com.Employee_Management_Backend.Entity.Leaveentity;
import com.Employee_Management_Backend.Repository.Leaverepository;
import com.Employee_Management_Backend.Services.Leaveservice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emplyee_management/employees/leaves")
public class LeaveController {

	@Autowired
	private Leaveservice leaveservice;
	
	@Autowired
	private Leaverepository leaverepository;
	
	
	 @PostMapping("/add_leave")
	    public ResponseEntity<?> addLeave(@RequestBody Leaveentity leave) {
		 
		 
		 Leaveentity addedLeave = leaveservice.addLeave(leave);
	        
	        if(addedLeave!=null) {
				return new ResponseEntity<Leaveentity> (addedLeave,HttpStatus.CREATED);
			}else{
				return new ResponseEntity<String> ("All values Should be Valid Formation!!!!",HttpStatus.BAD_REQUEST);
			}
	        
	    }
	 
	
	 @GetMapping("/leaves_list")
	    public ResponseEntity<?> getAllLeaves() {
	        
	        if(this.leaveservice.getAllLeaves().size()>0)
			{
				return new ResponseEntity<List<Leaveentity>>(this.leaveservice.getAllLeaves(),HttpStatus.OK);
			}
			else
			{
			    return new ResponseEntity<String>("NO Details Found",HttpStatus.NOT_FOUND);	
			}
	    }
	 
	 @GetMapping("/get/{leaveId}")
	    public ResponseEntity<Leaveentity> getLeaveById(@PathVariable int leaveId) {
		 
		 Leaveentity leave = leaveservice.getLeaveById(leaveId);
	        if (leave != null) {
	            return new ResponseEntity<>(leave, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
	 @GetMapping("/get/{empId}/leaves")
	 public ResponseEntity<List<Leaveentity>> getEmployeeLeaves(@PathVariable int empId) {
		 
	     List<Leaveentity> leaves = leaveservice.getEmployeeLeaves(empId);
	     if (leaves != null) {
	         return new ResponseEntity<>(leaves, HttpStatus.OK);
	     }
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	 
	 @PutMapping("/update/{leaveId}")
	    public ResponseEntity<Leaveentity> updateLeave(@PathVariable int leaveId, @RequestBody Leaveentity leave) {
		 
		 Leaveentity updatedLeave = leaveservice.updateLeave(leaveId, leave);
	        if (updatedLeave != null) {
	            return new ResponseEntity<>(updatedLeave, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	 
	 @DeleteMapping("/delete/{leaveId}")
	    public ResponseEntity<Void> deleteLeave(@PathVariable int leaveId) {
	        leaveservice.deleteLeave(leaveId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
	 
	 
}

package com.Employee_Management_Backend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.Employee_Management_Backend.Entity.UserEntity;
import com.Employee_Management_Backend.Exceptions.ResourceNotFoundException;
import com.Employee_Management_Backend.Repository.UserRepository;
import com.Employee_Management_Backend.Services.UserServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emplyee_management/user")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping()
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserEntity user){
		
		UserEntity usercheck=this.userServices.registerUser(user);
		if(usercheck!=null) {
			return new ResponseEntity<UserEntity> (usercheck,HttpStatus.CREATED);
		}else{
			return new ResponseEntity<String> ("All values Should be Not NULL and Once Check Confirm password is equal to password!!!!",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/loginUser")
	public ResponseEntity<?> LoginUser(@RequestBody UserEntity user){
		
		UserEntity usercheck=this.userServices.LoginUser(user);
		if(usercheck!=null) {
			return new ResponseEntity<UserEntity> (usercheck,HttpStatus.OK);
		}else{
			return new ResponseEntity<String> ("User Details Not Matching!!!!",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@GetMapping("/usersLists")
	public ResponseEntity<?> GetAllUser() 
	{
		if(this.userServices.getAllUser().size()>0)
		{
			return new ResponseEntity<List<UserEntity>>(this.userServices.getAllUser(),HttpStatus.OK);
		}
		else
		{
			  return new ResponseEntity<String>("NO Details Found",HttpStatus.NOT_FOUND);	
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id,@Valid @RequestBody UserEntity user) throws ResourceNotFoundException
	{
		UserEntity usercheck=this.userServices.updateUser(user, id);
		
		
		if(this.userServices.getAllUser().size()>0)
		{
			if(usercheck!=null) {
				return new ResponseEntity<UserEntity> (usercheck,HttpStatus.OK);
			}else {
				return new ResponseEntity<String> ("Kindly enter correct user and password!!!!",HttpStatus.BAD_REQUEST);
			}
		}
		else
		{
		 throw new ResourceNotFoundException("No User found!!");	
		}
			
	}
	
	
	  @GetMapping("/get/{userId}")
	    public ResponseEntity<UserEntity> getUserById(@PathVariable int userId) {
	    	
		  UserEntity user = userServices.getUserById(userId);
	        if (user == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }
	
	 
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable Integer id) throws ResourceNotFoundException
	{
		Map<String, String> response=new HashMap<String, String>();
		
		if(this.userRepository.findById(id).isPresent())
		{
			this.userServices.deleteUser(id);
			response.put("message", "user deleted!!");
			
			return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
		}
		else
		{
		throw new ResourceNotFoundException("No User found!!");	
 
		}
		
	}
	
	
	
	
	@PutMapping("/updateUser/{mobileNumber}")
	public ResponseEntity<?> updateUser(@PathVariable String mobileNumber, @Valid @RequestBody UserEntity user)
	        throws ResourceNotFoundException {
	    UserEntity userCheck = this.userServices.updateUserByMobileNumber(mobileNumber, user);

	    if (this.userServices.getAllUser().size() > 0) {
	        if (userCheck != null) {
	            return new ResponseEntity<UserEntity>(userCheck, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<String>("Kindly enter correct user and password!", HttpStatus.BAD_REQUEST);
	        }
	    } else {
	        throw new ResourceNotFoundException("No User found!!");
	    }
	}

	
	  @GetMapping("/get/mobile/{mobileNumber}")
	    public ResponseEntity<UserEntity> getUserByMobileNumber(@PathVariable String mobileNumber) {
	    	
		  UserEntity user = userServices.getUserByMobileNumber(mobileNumber);
	        if (user == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }
	
	
	

}

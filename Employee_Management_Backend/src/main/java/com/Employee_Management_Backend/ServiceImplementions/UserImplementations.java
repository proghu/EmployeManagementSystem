package com.Employee_Management_Backend.ServiceImplementions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.UserEntity;
import com.Employee_Management_Backend.Exceptions.ResourceNotFoundException;
import com.Employee_Management_Backend.Repository.UserRepository;
import com.Employee_Management_Backend.Services.UserServices;


@Service
public class UserImplementations implements UserServices{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity registerUser(UserEntity user) {
		// TODO Auto-generated method stub
		
		if(user.getPassword().equals(user.getConfirmpassword())) {
			
			return userRepository.save(user);
		}else {
			
			return null;
		}
	}

	@Override
	public UserEntity LoginUser(UserEntity user) {
		// TODO Auto-generated method stub
		
		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		
		
	}
	

	
	@Override
	public List<UserEntity> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public UserEntity updateUser(UserEntity user, int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
	
		UserEntity existinguser=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User id not found!!")); 
		
		existinguser.setFirstname(user.getFirstname());
		existinguser.setLastname(user.getLastname());
		existinguser.setUsername(user.getUsername());
		existinguser.setPassword(user.getPassword());
		existinguser.setConfirmpassword(user.getConfirmpassword());
		existinguser.setGender(user.getGender());
		existinguser.setAge(user.getAge());
		existinguser.setEmail(user.getEmail());
		existinguser.setMobilenumber(user.getMobilenumber());
		existinguser.setAddress(user.getAddress());
			
		if(user.getPassword().equals(user.getConfirmpassword())) {
			return this.userRepository.save(existinguser);
		}else {
			return null;
		}
		
	}

	@Override
	public void deleteUser(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity existinguser=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User id not found!!")); 
		this.userRepository.delete(existinguser);
		
	}

	@Override
	public UserEntity getUserById(int userId) {
		// TODO Auto-generated method stub
		
		 Optional<UserEntity> user = userRepository.findById(userId);
	        return user.orElse(null);
	}

	@Override
	public UserEntity updateUserByMobileNumber(String mobileNumber, UserEntity user) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		 UserEntity existingUser = userRepository.findByMobilenumber(mobileNumber);
		    if (existingUser == null) {
		        throw new ResourceNotFoundException("User with the provided mobile number not found!");
		    }

		    existingUser.setFirstname(user.getFirstname());
		    existingUser.setLastname(user.getLastname());
		    existingUser.setUsername(user.getUsername());
		    existingUser.setPassword(user.getPassword());
		    existingUser.setConfirmpassword(user.getConfirmpassword());
		    existingUser.setGender(user.getGender());
		    existingUser.setAge(user.getAge());
		    existingUser.setEmail(user.getEmail());
		    existingUser.setMobilenumber(user.getMobilenumber());
		    existingUser.setAddress(user.getAddress());

		    if (user.getPassword().equals(user.getConfirmpassword())) {
		        return this.userRepository.save(existingUser);
		    } else {
		        return null;
		    }
	}

	@Override
	public UserEntity getUserByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		 
		return userRepository.findByMobilenumber(mobileNumber);
	}

	


}

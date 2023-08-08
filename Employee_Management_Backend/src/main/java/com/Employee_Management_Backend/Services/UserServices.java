package com.Employee_Management_Backend.Services;

import java.util.List;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.UserEntity;
import com.Employee_Management_Backend.Exceptions.ResourceNotFoundException;




public interface UserServices {
	
	public UserEntity registerUser(UserEntity user);
	public UserEntity LoginUser(UserEntity user);
	List<UserEntity> getAllUser();
	
	UserEntity getUserById(int userId);
	
	UserEntity updateUser(UserEntity user,int id) throws ResourceNotFoundException;
	
	void deleteUser(int id) throws ResourceNotFoundException;
	
	UserEntity updateUserByMobileNumber(String mobileNumber, UserEntity user) throws ResourceNotFoundException;
	
	UserEntity getUserByMobileNumber(String mobileNumber);


}

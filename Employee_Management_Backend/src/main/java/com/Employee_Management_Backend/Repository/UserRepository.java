package com.Employee_Management_Backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee_Management_Backend.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	public UserEntity findByUsernameAndPassword(String username,String password);
	
	public UserEntity findByMobilenumber(String mobilenumber);
}

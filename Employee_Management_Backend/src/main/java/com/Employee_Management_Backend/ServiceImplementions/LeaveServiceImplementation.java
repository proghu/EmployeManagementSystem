package com.Employee_Management_Backend.ServiceImplementions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.EmployeeQualifications;
import com.Employee_Management_Backend.Entity.Leaveentity;
import com.Employee_Management_Backend.Repository.EmployeeRepository;
import com.Employee_Management_Backend.Repository.Leaverepository;
import com.Employee_Management_Backend.Services.Leaveservice;

@Service
public class LeaveServiceImplementation implements Leaveservice{
	
	@Autowired
	private Leaverepository  leaverepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Leaveentity> getAllLeaves() {
		// TODO Auto-generated method stub
		 return leaverepository.findAll();
	}

	@Override
	public Leaveentity getLeaveById(int leaveId) {
		// TODO Auto-generated method stub
		
		 
		 Optional<Leaveentity> Leave = leaverepository.findById(leaveId);
	        return Leave.orElse(null);

	}

	@Override
	public Leaveentity addLeave(Leaveentity leave) {
		// TODO Auto-generated method stub
		
		// return leaverepository.save(leave);
		
		int empId=leave.getEmployee().getEmpId();
		    EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);

		    if (employee != null) {
		        leave.setEmployee(employee);
		        return leaverepository.save(leave);
		    }
		    return null;
		
	}

	@Override
	public Leaveentity updateLeave(int leaveId, Leaveentity leave) {
		// TODO Auto-generated method stub
		
//		 Leaveentity existingLeave = leaverepository.findById(leaveId).orElse(null);
//	        if (existingLeave != null) {
//	            existingLeave.setEmployee(leave.getEmployee());
//	            existingLeave.setDate(leave.getDate());
//	            existingLeave.setReason(leave.getReason());
//	            return leaverepository.save(existingLeave);
//	        }
//	        return null;
		
		  Leaveentity existingLeave = leaverepository.findById(leaveId).orElse(null);
	        if (existingLeave != null) {
	            int empId = leave.getEmployee().getEmpId();
	            EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);

	            if (employee != null) {
	                existingLeave.setEmployee(employee);
	                existingLeave.setDate(leave.getDate());
	                existingLeave.setReason(leave.getReason());
	                return leaverepository.save(existingLeave);
	            }
	        }
	        return null;
		
	
		
	}

	@Override
	public void deleteLeave(int leaveId) {
		// TODO Auto-generated method stub
		
		leaverepository.deleteById(leaveId);
		
	}
	
	@Override
	public List<Leaveentity> getEmployeeLeaves(int empId) {
	    EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);
	    if (employee != null) {
	        return leaverepository.findByEmployee(employee);
	    }
	    return null;
	}

}

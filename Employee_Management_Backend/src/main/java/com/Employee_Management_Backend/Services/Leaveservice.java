package com.Employee_Management_Backend.Services;

import java.util.List;

import com.Employee_Management_Backend.Entity.Leaveentity;

public interface Leaveservice {

	 List<Leaveentity> getAllLeaves();
	 Leaveentity getLeaveById(int leaveId);
	 Leaveentity addLeave(Leaveentity leave);
	 Leaveentity updateLeave(int leaveId, Leaveentity leave);
	    void deleteLeave(int leaveId);
	    
		List<Leaveentity> getEmployeeLeaves(int empId);
}

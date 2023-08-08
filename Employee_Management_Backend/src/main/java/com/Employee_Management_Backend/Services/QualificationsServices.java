package com.Employee_Management_Backend.Services;

import java.util.List;

import com.Employee_Management_Backend.Entity.EmployeeQualifications;

public interface QualificationsServices {
	
	  List<EmployeeQualifications> getAllQualifications();

	  EmployeeQualifications getQualificationById(int qualificationId);

	  EmployeeQualifications createQualification(EmployeeQualifications qualification);

	  EmployeeQualifications updateQualification(int qualificationId, EmployeeQualifications qualification);

	  void deleteQualification(int qualificationId);

}

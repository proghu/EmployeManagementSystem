package com.Employee_Management_Backend.ServiceImplementions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.EmployeeQualifications;
import com.Employee_Management_Backend.Repository.EmployeeRepository;
import com.Employee_Management_Backend.Repository.QualificationsRepository;
import com.Employee_Management_Backend.Services.QualificationsServices;

@Service
public class QualificationsImplementations  implements QualificationsServices{
	
	@Autowired
	private QualificationsRepository qualificationsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeQualifications> getAllQualifications() {
		// TODO Auto-generated method stub
		 return this.qualificationsRepository.findAll();
	}

	@Override
	public EmployeeQualifications getQualificationById(int qualificationId) {
		// TODO Auto-generated method stub
		
		 Optional<EmployeeQualifications> employeeQualify = qualificationsRepository.findById(qualificationId);
	        return employeeQualify.orElse(null);
		
		//return qualificationsRepository.findById(qualificationId).orElse(null);
	}

	@Override
	public EmployeeQualifications createQualification(EmployeeQualifications qualification) {
		// TODO Auto-generated method stub
		
		// return qualificationsRepository.save(qualification);
		
		 int empId = qualification.getEmployee().getEmpId();
		    EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);
		    
		    if (employee != null) {
		        qualification.setEmployee(employee);
		        return qualificationsRepository.save(qualification);
		    }
		    
		    return null;
		
	}

	@Override
	public EmployeeQualifications updateQualification(int qualificationId, EmployeeQualifications qualification) {
		// TODO Auto-generated method stub
		
//		EmployeeQualifications existingQualification = qualificationsRepository.findById(qualificationId).orElse(null);
//        if (existingQualification != null) {
//        	existingQualification.setEmployee(qualification.getEmployee());
//            existingQualification.setPosition(qualification.getPosition());
//            existingQualification.setRequirements(qualification.getRequirements());
//            existingQualification.setDateIn(qualification.getDateIn());
//            return qualificationsRepository.save(existingQualification);
//        }
//        return null;
		
		
		
		EmployeeQualifications existingQualification = qualificationsRepository.findById(qualificationId).orElse(null);
	    
	    if (existingQualification != null) {
	    	
	        EmployeeEntity employee = employeeRepository.findById(qualification.getEmployee().getEmpId()).orElse(null);
	        
	        if (employee != null) {
	            existingQualification.setEmployee(employee);
	        }
	        
	        existingQualification.setPosition(qualification.getPosition());
	        existingQualification.setRequirements(qualification.getRequirements());
	        existingQualification.setDateIn(qualification.getDateIn());
	        
	        return qualificationsRepository.save(existingQualification);
	    }
	    
	    return null;
		
	}

	@Override
	public void deleteQualification(int qualificationId) {
		// TODO Auto-generated method stub
		
		qualificationsRepository.deleteById(qualificationId);
		
	}

}

package com.Employee_Management_Backend.ServiceImplementions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.EmployeeQualifications;
import com.Employee_Management_Backend.Entity.JobDepartment;
import com.Employee_Management_Backend.Entity.SalaryBonusEntity;
import com.Employee_Management_Backend.Repository.JobDepartmentRepository;
import com.Employee_Management_Backend.Repository.SalaryBonusRepository;
import com.Employee_Management_Backend.Services.SalaryBonusService;

@Service
public class SalaryBonusServiceImplementation implements SalaryBonusService{
	
	@Autowired
	private SalaryBonusRepository salaryBonusRepository;
	
	@Autowired
	private JobDepartmentRepository jobDepartmentRepository;

	@Override
	public List<SalaryBonusEntity> getAllSalaryBonuses() {
		// TODO Auto-generated method stub
		return salaryBonusRepository.findAll();
	}

	@Override
	public SalaryBonusEntity getSalaryBonusById(int salaryId) {
		// TODO Auto-generated method stub
		
		 Optional<SalaryBonusEntity> SalaryBonus = salaryBonusRepository.findById(salaryId);
	        return SalaryBonus.orElse(null);
	}

	@Override
	public SalaryBonusEntity createSalaryBonus(SalaryBonusEntity salaryBonus) {
		// TODO Auto-generated method stub
		
		//return salaryBonusRepository.save(salaryBonus);
		
		int jobId = salaryBonus.getJobDepartment().getJobId();
		
        JobDepartment jobDepartment = jobDepartmentRepository.findById(salaryBonus.getJobDepartment().getJobId()).orElse(null);
        if (jobDepartment != null) {
            salaryBonus.setJobDepartment(jobDepartment);
            return salaryBonusRepository.save(salaryBonus);
        }
        return null;
        
        
	}

	@Override
	public SalaryBonusEntity updateSalaryBonus(int salaryId, SalaryBonusEntity salaryBonus) {
		// TODO Auto-generated method stub
		
//		SalaryBonusEntity existingSalaryBonus = getSalaryBonusById(salaryId);
//	        existingSalaryBonus.setJobDepartment(salaryBonus.getJobDepartment());
//	        existingSalaryBonus.setAmount(salaryBonus.getAmount());
//	        existingSalaryBonus.setAnnualExpense(salaryBonus.getAnnualExpense());
//	        existingSalaryBonus.setBonus(salaryBonus.getBonus());
//	        return salaryBonusRepository.save(existingSalaryBonus);
		
		
		
		SalaryBonusEntity existingSalaryBonus = getSalaryBonusById(salaryId);
		
        if (existingSalaryBonus != null) {
        	
            int jobId = salaryBonus.getJobDepartment().getJobId();
            JobDepartment jobDepartment = jobDepartmentRepository.findById(jobId).orElse(null);
            if (jobDepartment != null) {
                existingSalaryBonus.setJobDepartment(jobDepartment);
            }
                existingSalaryBonus.setAmount(salaryBonus.getAmount());
                existingSalaryBonus.setAnnualExpense(salaryBonus.getAnnualExpense());
                existingSalaryBonus.setBonus(salaryBonus.getBonus());
                return salaryBonusRepository.save(existingSalaryBonus);
            
        }
        return null;
        
		
	  
	}

	@Override
	public void deleteSalaryBonus(int salaryId) {
		// TODO Auto-generated method stub
		
		 salaryBonusRepository.deleteById(salaryId);
		
	}

}

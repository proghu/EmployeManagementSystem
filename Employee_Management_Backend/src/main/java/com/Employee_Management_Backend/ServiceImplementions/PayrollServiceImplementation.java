package com.Employee_Management_Backend.ServiceImplementions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Management_Backend.Entity.EmployeeEntity;
import com.Employee_Management_Backend.Entity.JobDepartment;
import com.Employee_Management_Backend.Entity.Leaveentity;
import com.Employee_Management_Backend.Entity.Payroll;
import com.Employee_Management_Backend.Entity.SalaryBonusEntity;
import com.Employee_Management_Backend.Exceptions.ResourceNotFoundException;
import com.Employee_Management_Backend.Repository.EmployeeRepository;
import com.Employee_Management_Backend.Repository.JobDepartmentRepository;
import com.Employee_Management_Backend.Repository.Leaverepository;
import com.Employee_Management_Backend.Repository.PayrollRepository;
import com.Employee_Management_Backend.Repository.SalaryBonusRepository;
import com.Employee_Management_Backend.Services.PayrollService;

@Service
public class PayrollServiceImplementation implements PayrollService{
	
	@Autowired
	private PayrollRepository payrollRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private JobDepartmentRepository jobDepartmentRepository;
	
	@Autowired
	private SalaryBonusRepository salaryBonusRepository;
	
	@Autowired
	private Leaverepository leaverepository;

	@Override
	public Payroll createPayroll(Payroll payroll) {
		// TODO Auto-generated method stub
		// return payrollRepository.save(payroll);
				
		
		 EmployeeEntity employee = employeeRepository.findById(payroll.getEmployee().getEmpId()).orElse(null);
		    if (employee != null) {
		        payroll.setEmployee(employee);
		        
		        // Fetch job department details if available
		        if (payroll.getJobDepartment() != null) {
		            JobDepartment jobDepartment = jobDepartmentRepository.findById(payroll.getJobDepartment().getJobId()).orElse(null);
		            payroll.setJobDepartment(jobDepartment);
		        }
		        
		        // Fetch salary bonus details if available
		        if (payroll.getSalaryBonusEntity() != null) {
		            SalaryBonusEntity salaryBonusEntity = salaryBonusRepository.findById(payroll.getSalaryBonusEntity().getSalaryId()).orElse(null);
		            payroll.setSalaryBonusEntity(salaryBonusEntity);
		        }
		        
		        // Fetch leave details if available
		        if (payroll.getLeaveentity() != null) {
		            Leaveentity leaveentity = leaverepository.findById(payroll.getLeaveentity().getLeave_ID()).orElse(null);
		            payroll.setLeaveentity(leaveentity);
		        }
		   
		        
		        
		        return payrollRepository.save(payroll);
		    }
		    return null;
		
		
	}

	@Override
	public Payroll getPayrollById(int payrollId) {
		// TODO Auto-generated method stub

		Optional<Payroll> payroll = payrollRepository.findById(payrollId);
        return payroll.orElse(null);
	 
	}

	@Override
	public List<Payroll> getAllPayrolls() {
		// TODO Auto-generated method stub
		
		 return payrollRepository.findAll();
	}

	@Override
	public Payroll updatePayroll(int payrollId, Payroll payrollDetails){
		// TODO Auto-generated method stub
		
		
		
//		 Payroll existingPayroll = payrollRepository.findById(payrollId).orElse(null);
//	        if (existingPayroll != null) {
//	        	
//	        existingPayroll.setEmpId(payrollDetails.getEmpId());
//	        existingPayroll.setJobId(payrollDetails.getJobId());
//	        existingPayroll.setSalaryId(payrollDetails.getSalaryId());
//	        existingPayroll.setLeaveId(payrollDetails.getLeaveId());
//	        existingPayroll.setDate(payrollDetails.getDate());
//	        existingPayroll.setReport(payrollDetails.getReport());
//	        existingPayroll.setTotalAmount(payrollDetails.getTotalAmount());
//	        return payrollRepository.save(existingPayroll);
//	        }else {
//	        	return null;
//	        }
		
		
		 Payroll existingPayroll = payrollRepository.findById(payrollId).orElse(null);
		 
		    if (existingPayroll != null) {
		        EmployeeEntity employee = employeeRepository.findById(payrollDetails.getEmployee().getEmpId()).orElse(null);
		        if (employee != null) {
		            existingPayroll.setEmployee(employee);
		            
		            // Fetch job department details if available
		            if (payrollDetails.getJobDepartment() != null) {
		                JobDepartment jobDepartment = jobDepartmentRepository.findById(payrollDetails.getJobDepartment().getJobId()).orElse(null);
		                existingPayroll.setJobDepartment(jobDepartment);
		            }
		            
		            // Fetch salary bonus details if available
		            if (payrollDetails.getSalaryBonusEntity() != null) {
		                SalaryBonusEntity salaryBonusEntity = salaryBonusRepository.findById(payrollDetails.getSalaryBonusEntity().getSalaryId()).orElse(null);
		                existingPayroll.setSalaryBonusEntity(salaryBonusEntity);
		            }
		            
		            // Fetch leave details if available
		            if (payrollDetails.getLeaveentity() != null) {
		                Leaveentity leaveentity = leaverepository.findById(payrollDetails.getLeaveentity().getLeave_ID()).orElse(null);
		                existingPayroll.setLeaveentity(leaveentity);
		            }
		            
		            
		            
		            existingPayroll.setDate(payrollDetails.getDate());
		            existingPayroll.setReport(payrollDetails.getReport());
		            existingPayroll.setTotalAmount(payrollDetails.getTotalAmount());
		            return payrollRepository.save(existingPayroll);
		        }
		        return null;
		    }
		    return null;
	    
		
	}

	@Override
	public void deletePayroll(int payrollId) {
		// TODO Auto-generated method stub
		payrollRepository.deleteById(payrollId);
	}

}

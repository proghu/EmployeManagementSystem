package com.Employee_Management_Backend.ServiceImplementions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Management_Backend.Entity.JobDepartment;
import com.Employee_Management_Backend.Entity.SalaryBonusEntity;
import com.Employee_Management_Backend.Repository.JobDepartmentRepository;
import com.Employee_Management_Backend.Services.JobDepartmentService;

@Service
public class JobDepartmentServiceImpl implements JobDepartmentService{
	
	@Autowired
	private JobDepartmentRepository jobDepartmentRepository;

	@Override
	public List<JobDepartment> getAllJobDepartments() {
		// TODO Auto-generated method stub
		return this.jobDepartmentRepository.findAll();
	}

	@Override
	public JobDepartment getJobDepartmentById(int jobId) {
		// TODO Auto-generated method stub
		
		 return jobDepartmentRepository.findById(jobId).orElse(null);
		   
	}

	@Override
	public JobDepartment createJobDepartment(JobDepartment jobDepartment) {
		// TODO Auto-generated method stub
		 return jobDepartmentRepository.save(jobDepartment);
		  
	}

	@Override
	public JobDepartment updateJobDepartment(int jobId, JobDepartment jobDepartment) {
		// TODO Auto-generated method stub
		JobDepartment existingJobDepartment = jobDepartmentRepository.findById(jobId).orElse(null);
        if (existingJobDepartment != null) {
            existingJobDepartment.setJobDepartments(jobDepartment.getJobDepartments());
            existingJobDepartment.setJobName(jobDepartment.getJobName());
            existingJobDepartment.setDescription(jobDepartment.getDescription());
            existingJobDepartment.setSalaryRange(jobDepartment.getSalaryRange());
            return jobDepartmentRepository.save(existingJobDepartment);
        }
        return null;
	}

	@Override
	public void deleteJobDepartment(int jobId) {
		// TODO Auto-generated method stub
		
		 jobDepartmentRepository.deleteById(jobId);
		
	}

	@Override
	public List<SalaryBonusEntity> getSalaryBonusesByJobDepartmentId(int jobId) {
		// TODO Auto-generated method stub
		
		
		
		JobDepartment jobDepartment = jobDepartmentRepository.findById(jobId).orElse(null);
        if (jobDepartment != null) {
            return jobDepartment.getSalaryBonuses();
        }
        return null;
		
	}

	@Override
	public List<JobDepartment> getDepartmentByjobName(String jobName) {
		// TODO Auto-generated method stub
		return jobDepartmentRepository.getDepartmentByjobName(jobName);
	}

}

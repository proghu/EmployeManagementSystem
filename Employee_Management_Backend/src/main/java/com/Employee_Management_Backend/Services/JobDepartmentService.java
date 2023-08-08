package com.Employee_Management_Backend.Services;

import java.util.List;

import com.Employee_Management_Backend.Entity.JobDepartment;
import com.Employee_Management_Backend.Entity.SalaryBonusEntity;

public interface JobDepartmentService {
	
	List<JobDepartment> getAllJobDepartments();
    JobDepartment getJobDepartmentById(int jobId);
    JobDepartment createJobDepartment(JobDepartment jobDepartment);
    JobDepartment updateJobDepartment(int jobId, JobDepartment jobDepartment);
    void deleteJobDepartment(int jobId);
    
    List<SalaryBonusEntity> getSalaryBonusesByJobDepartmentId(int jobId);
    
    List<JobDepartment> getDepartmentByjobName(String jobName);

}

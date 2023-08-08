package com.Employee_Management_Backend.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "JobDepartment")
public class JobDepartment {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "job_ID")
	    private int jobId;

		@NotEmpty(message = "jobDepartment is required")
	    @Column(name = "job_dept", length = 30)
	    private String jobDepartments;

		@NotEmpty(message = "jobName is required")
	    @Column(name = "job_name", length = 30)
	    private String jobName;

		@NotEmpty(message = "description is required")
	    @Column(name = "description", length = 30)
	    private String description;

		@NotEmpty(message = "salaryRange is required")
	    @Column(name = "salary_range", length = 30)
	    private String salaryRange;
		
		
		
		// mapping
		
		@OneToMany(mappedBy = "jobDepartment", cascade = CascadeType.ALL)
		  @JsonIgnore
		  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private List<SalaryBonusEntity> salaryBonuses;
		
		@OneToMany(mappedBy = "jobDepartment", cascade = CascadeType.ALL)
		@JsonIgnore
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private List<Payroll> payrolls;

		

		public JobDepartment() {
			super();
		}

		
		


		public JobDepartment(int jobId, @NotEmpty(message = "jobDepartment is required") String jobDepartments,
				@NotEmpty(message = "jobName is required") String jobName,
				@NotEmpty(message = "description is required") String description,
				@NotEmpty(message = "salaryRange is required") String salaryRange,
				List<SalaryBonusEntity> salaryBonuses, List<Payroll> payrolls) {
			super();
			this.jobId = jobId;
			this.jobDepartments = jobDepartments;
			this.jobName = jobName;
			this.description = description;
			this.salaryRange = salaryRange;
			this.salaryBonuses = salaryBonuses;
			this.payrolls = payrolls;
		}





		public List<Payroll> getPayrolls() {
			return payrolls;
		}





		public void setPayrolls(List<Payroll> payrolls) {
			this.payrolls = payrolls;
		}





		public List<SalaryBonusEntity> getSalaryBonuses() {
			return salaryBonuses;
		}



		public void setSalaryBonuses(List<SalaryBonusEntity> salaryBonuses) {
			this.salaryBonuses = salaryBonuses;
		}



		public int getJobId() {
			return jobId;
		}

		public void setJobId(int jobId) {
			this.jobId = jobId;
		}

		public String getJobDepartments() {
			return jobDepartments;
		}

		public void setJobDepartments(String jobDepartments) {
			this.jobDepartments = jobDepartments;
		}

		public String getJobName() {
			return jobName;
		}

		public void setJobName(String jobName) {
			this.jobName = jobName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getSalaryRange() {
			return salaryRange;
		}

		public void setSalaryRange(String salaryRange) {
			this.salaryRange = salaryRange;
		}
		
		

}

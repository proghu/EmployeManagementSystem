package com.Employee_Management_Backend.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee_payroll")
public class Payroll {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "payroll_id")
	    private int payrollId;

//	    @NotNull(message = "Employee ID is required")
//	    @Column(name = "emp_id")
//	    private int empId;
//
//	    @NotNull(message = "Job ID is required")
//	    @Column(name = "job_id")
//	    private int jobId;
//
//	    @NotNull(message = "Salary ID is required")
//	    @Column(name = "salary_id")
//	    private int salaryId;
//
//	    @NotNull(message = "Leave ID is required")
//	    @Column(name = "leave_id")
//	    private int leaveId;
	    
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "emp_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private EmployeeEntity employee;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "job_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private JobDepartment jobDepartment;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "salary_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private SalaryBonusEntity salaryBonusEntity;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "Leave_ID")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Leaveentity leaveentity;

	    

	    

	    @NotNull(message = "Date of Payroll is required")
	    @Column(name = "date")
	    @Temporal(TemporalType.DATE)
	    private Date date;

	    @NotEmpty(message = "report of Payroll is required")
	    @Column(name = "report")
	    private String report;

	    @NotNull(message = "Total Amount is required")
	    @Column(name = "total_amount")
	    private int totalAmount;

		public Payroll() {
			super();
		}

		
		
		public Payroll(int payrollId, EmployeeEntity employee, JobDepartment jobDepartment,
				SalaryBonusEntity salaryBonusEntity, Leaveentity leaveentity,
				@NotNull(message = "Date of Payroll is required") Date date,
				@NotEmpty(message = "report of Payroll is required") String report,
				@NotNull(message = "Total Amount is required") int totalAmount) {
			super();
			this.payrollId = payrollId;
			this.employee = employee;
			this.jobDepartment = jobDepartment;
			this.salaryBonusEntity = salaryBonusEntity;
			this.leaveentity = leaveentity;
			this.date = date;
			this.report = report;
			this.totalAmount = totalAmount;
		}



		public int getPayrollId() {
			return payrollId;
		}

		public void setPayrollId(int payrollId) {
			this.payrollId = payrollId;
		}

		public EmployeeEntity getEmployee() {
			return employee;
		}

		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}

		public JobDepartment getJobDepartment() {
			return jobDepartment;
		}

		public void setJobDepartment(JobDepartment jobDepartment) {
			this.jobDepartment = jobDepartment;
		}

		public SalaryBonusEntity getSalaryBonusEntity() {
			return salaryBonusEntity;
		}

		public void setSalaryBonusEntity(SalaryBonusEntity salaryBonusEntity) {
			this.salaryBonusEntity = salaryBonusEntity;
		}

		public Leaveentity getLeaveentity() {
			return leaveentity;
		}

		public void setLeaveentity(Leaveentity leaveentity) {
			this.leaveentity = leaveentity;
		}
		

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getReport() {
			return report;
		}

		public void setReport(String report) {
			this.report = report;
		}

		public int getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(int totalAmount) {
			this.totalAmount = totalAmount;
		}

	
	    
	    
	
}

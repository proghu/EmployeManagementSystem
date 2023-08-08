package com.Employee_Management_Backend.Entity;

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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Salary_Bonus")
public class SalaryBonusEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_ID")
    private int salaryId;

//    @Column(name = "job_ID")
//    private int jobId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_ID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private JobDepartment jobDepartment;

    @Column(name = "amount")
    private int amount;

    @Column(name = "annual")
    @NotEmpty(message = "Annual Expense is required")
    private String annualExpense;

    @Column(name = "bonus")
    @NotEmpty(message = "Bonus is required")
    private String bonus;
    
    
    @OneToMany(mappedBy = "salaryBonusEntity", cascade = CascadeType.ALL)
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Payroll> payrolls;


	public SalaryBonusEntity() {
		super();
	}

	
	

	public SalaryBonusEntity(int salaryId, JobDepartment jobDepartment, int amount,
			@NotEmpty(message = "Annual Expense is required") String annualExpense,
			@NotEmpty(message = "Bonus is required") String bonus, List<Payroll> payrolls) {
		super();
		this.salaryId = salaryId;
		this.jobDepartment = jobDepartment;
		this.amount = amount;
		this.annualExpense = annualExpense;
		this.bonus = bonus;
		this.payrolls = payrolls;
	}




	public List<Payroll> getPayrolls() {
		return payrolls;
	}




	public void setPayrolls(List<Payroll> payrolls) {
		this.payrolls = payrolls;
	}




	public int getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}


	public JobDepartment getJobDepartment() {
		return jobDepartment;
	}


	public void setJobDepartment(JobDepartment jobDepartment) {
		this.jobDepartment = jobDepartment;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAnnualExpense() {
		return annualExpense;
	}

	public void setAnnualExpense(String annualExpense) {
		this.annualExpense = annualExpense;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
    
    

}

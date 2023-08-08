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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employees_leave")
public class Leaveentity {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int Leave_ID;

//	    @Column(name = "empId")
//	    @NotNull(message = "Employee ID is required")
//	    private int empId;
	 	
	 	@ManyToOne(fetch = FetchType.LAZY)
	 	@JoinColumn(name = "empId")
	 	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 	private EmployeeEntity employee;
	 	


	    @NotNull(message = "date is required")
	    @Column(name = "date")
	    @Temporal(TemporalType.DATE)
	    private Date date;

	    @Column(name = "reason")
	    @NotEmpty(message = "Reason is required")
	    private String reason;
	    
	  
	    @OneToMany(mappedBy = "leaveentity", cascade = CascadeType.ALL)
		@JsonIgnore
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private List<Payroll> payrolls;
	  

		public Leaveentity() {
			super();
		}

		

		



		public Leaveentity(int Leave_ID, EmployeeEntity employee, @NotNull(message = "date is required") Date date,
				@NotEmpty(message = "Reason is required") String reason, List<Payroll> payrolls) {
			super();
			this.Leave_ID = Leave_ID;
			this.employee = employee;
			this.date = date;
			this.reason = reason;
			this.payrolls = payrolls;
		}







		public List<Payroll> getPayrolls() {
			return payrolls;
		}







		public void setPayrolls(List<Payroll> payrolls) {
			this.payrolls = payrolls;
		}







		public int getLeave_ID() {
			return Leave_ID;
		}

		public void setLeave_ID(int Leave_ID) {
			this.Leave_ID = Leave_ID;
		}

		

	

		public EmployeeEntity getEmployee() {
			return employee;
		}



		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}



		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

	    

}

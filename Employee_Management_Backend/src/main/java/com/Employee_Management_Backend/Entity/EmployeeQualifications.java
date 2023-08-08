package com.Employee_Management_Backend.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Employee_Qualifications")
public class EmployeeQualifications {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "qual_ID")
	    private int qualificationId;

//	 	@Column(name = "empId")
//	    @NotNull(message = "emp_id is required")
//	    private int empId;
	 	
	 	// mapping 
	 	

	 	@ManyToOne(fetch = FetchType.LAZY)
	 	@JoinColumn(name = "emp_id")
	 	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 	private EmployeeEntity employee;
	 	
	    @Column(name = "position")
	    @NotEmpty(message = "Position is required")
	    private String position;

	    @Column(name = "requirements")
	    @NotEmpty(message = "Requirements are required")
	    private String requirements;

	    @Column(name = "date_in")
	    @Temporal(TemporalType.DATE)
	    private Date dateIn;

		public EmployeeQualifications() {
			super();
		}

	

		public EmployeeQualifications(int qualificationId, EmployeeEntity employee,
				@NotEmpty(message = "Position is required") String position,
				@NotEmpty(message = "Requirements are required") String requirements, Date dateIn) {
			super();
			this.qualificationId = qualificationId;
			this.employee = employee;
			this.position = position;
			this.requirements = requirements;
			this.dateIn = dateIn;
		}



		public int getQualificationId() {
			return qualificationId;
		}

		public void setQualificationId(int qualificationId) {
			this.qualificationId = qualificationId;
		}


		public EmployeeEntity getEmployee() {
			return employee;
		}

		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getRequirements() {
			return requirements;
		}

		public void setRequirements(String requirements) {
			this.requirements = requirements;
		}

		public Date getDateIn() {
			return dateIn;
		}

		public void setDateIn(Date dateIn) {
			this.dateIn = dateIn;
		}
	    
		
	    

}

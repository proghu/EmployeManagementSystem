package com.Employee_Management_Backend.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Employee_Tables")
public class EmployeeEntity {
	
	 	@Id
	 	@GeneratedValue(generator="emp_seq")
		@SequenceGenerator(name="emp_seq", sequenceName="emp_seq", allocationSize=1, initialValue=1000)
	    private int empId;

	 	@NotEmpty
		@Size(min=3, message = "First name must contain 3 letters")
		@Column(name="First_name",length = 50)
	    private String firstName;

	    @Column(name = "Last_name", length = 50)
	    private String lastName;

	    @NotEmpty
		@Column(name="Gender",length = 10)
	    private String gender;

	    @NotEmpty
	    @Column(name = "Age", length = 10)
	    @Size(min = 1, max = 10)
	    @Min(value = 21, message = "Age should be above 20")
	    private String age;

	    @NotEmpty
		@Column(name="Address",length = 100)
	    private String contactAddress;

	    @NotEmpty
		@Size(min=5, message = "E-mail must contain 5 letters")
		@Email(message = "Given mail id is not valid")
		@Column(name="Email",length = 50)
	    private String employeeEmail;

	    @NotEmpty
		@Size(min=5, message = "Password must contain 5 letters")
		@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
		@Column(name="Employee_password",length = 20)
	    private String employeePassword;
	    
	    //mapping
	    

	    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	    @JsonIgnore // Exclude from serialization to avoid infinite loop
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private List<EmployeeQualifications> qualifications;


	    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	    @JsonIgnore
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private List<Leaveentity> leaves;

	    
	    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	    @JsonIgnore
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private List<Payroll> payrolls;


		public EmployeeEntity() {
			super();
		}


		
		public EmployeeEntity(int empId,
				@NotEmpty @Size(min = 3, message = "First name must contain 3 letters") String firstName,
				String lastName, @NotEmpty String gender,
				@NotEmpty @Size(min = 1, max = 10) @Min(value = 21, message = "Age should be above 20") String age,
				@NotEmpty String contactAddress,
				@NotEmpty @Size(min = 5, message = "E-mail must contain 5 letters") @Email(message = "Given mail id is not valid") String employeeEmail,
				@NotEmpty @Size(min = 5, message = "Password must contain 5 letters") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String employeePassword,
				List<EmployeeQualifications> qualifications, List<Leaveentity> leaves, List<Payroll> payrolls) {
			super();
			this.empId = empId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.age = age;
			this.contactAddress = contactAddress;
			this.employeeEmail = employeeEmail;
			this.employeePassword = employeePassword;
			this.qualifications = qualifications;
			this.leaves = leaves;
			this.payrolls = payrolls;
		}



		public List<Payroll> getPayrolls() {
			return payrolls;
		}



		public void setPayrolls(List<Payroll> payrolls) {
			this.payrolls = payrolls;
		}



		public List<Leaveentity> getLeaves() {
			return leaves;
		}



		public void setLeaves(List<Leaveentity> leaves) {
			this.leaves = leaves;
		}



		public List<EmployeeQualifications> getQualifications() {
			return qualifications;
		}




		public void setQualifications(List<EmployeeQualifications> qualifications) {
			this.qualifications = qualifications;
		}


		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getContactAddress() {
			return contactAddress;
		}

		public void setContactAddress(String contactAddress) {
			this.contactAddress = contactAddress;
		}

		public String getEmployeeEmail() {
			return employeeEmail;
		}

		public void setEmployeeEmail(String employeeEmail) {
			this.employeeEmail = employeeEmail;
		}

		public String getEmployeePassword() {
			return employeePassword;
		}

		public void setEmployeePassword(String employeePassword) {
			this.employeePassword = employeePassword;
		}

	
		
		


}

package com.Employee_Management_Backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="User_Tables")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Size(min=3, message = "First name must contain 3 letters")
	@Column(name="first_name",length = 50)
	private String firstname;
	
	@Column(name="last_name",length = 30)
	private String lastname;
	
	@NotEmpty
	@Size(min=3, message = "User name must contain 3 letters")
	@Column(name="user_name",length = 30)
	private String username;
	
	@NotEmpty
	@Size(min=5, message = "Password must contain 5 letters")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(name="password",length = 20)
	private String password;
	
	@NotEmpty
	@Size(min=5, message = "Confirm Password must contain 5 letters")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(name="confirm_password",length = 20)
	private String confirmpassword;
	
	@NotEmpty
	@Column(name="Gender",length = 10)
	private String gender;
	
	@NotEmpty
    @Column(name = "Age", length = 10)
    @Size(min = 1, max = 10)
    @Min(value = 21, message = "Age should be above 21")
    private String age;
	
	@NotEmpty
	@Size(min=5, message = "E-mail must contain 5 letters")
	@Email(message = "Given mail id is not valid")
	@Column(name="email",length = 50)
	private String email;
	
	@NotEmpty
	@Size(min=10, message = "Moile numbers must contain 10 letters")
	@Column(name="mobile_numbers",length = 10)
	private String mobilenumber;
	
	
	@NotEmpty
	@Column(name="Address",length = 100)
	private String address;


	public UserEntity() {
		super();
	}


	public UserEntity(int id, @NotEmpty @Size(min = 3, message = "First name must contain 3 letters") String firstname,
			String lastname, @NotEmpty @Size(min = 3, message = "User name must contain 3 letters") String username,
			@NotEmpty @Size(min = 5, message = "Password must contain 5 letters") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String password,
			@NotEmpty @Size(min = 5, message = "Confirm Password must contain 5 letters") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String confirmpassword,
			@NotEmpty String gender, @NotEmpty String age,
			@NotEmpty @Size(min = 5, message = "E-mail must contain 5 letters") @Email(message = "Given mail id is not valid") String email,
			@NotEmpty @Size(min = 10, message = "Moile numbers must contain 10 letters") String mobilenumber,
			@NotEmpty String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
	
}

package com.cg.webapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull(message="Name is Mandatory")
	private String customerName;
	
	@Email(message="Enter Valid Email")
	@NotNull(message="Email is Mandatory")
	private String email;
	
	@Size(min=8,max=8 ,message = "Password length should be 8")
//	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$",message = "Enter a valid password")
	@NotNull(message="Entering Password is Mandatory")
	private String password;
	
	@NotNull(message="Enter Address properly")
	private String adddress;
	
	@Size(min=10,max=10,message = "Mobile no should be 10 digit")
	@Pattern(regexp = "[789][0-9]{9}",message = "Enter valid mobile number")
	@NotNull(message="Mobile Number is Mandatory")
	private String mobileNo;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<IPackage> packages= new ArrayList<IPackage>();
	
	
	
	
	
	
	
	
	
	
}

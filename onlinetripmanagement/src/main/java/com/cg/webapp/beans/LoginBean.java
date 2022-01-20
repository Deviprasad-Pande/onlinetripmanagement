package com.cg.webapp.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBean {
	
	@NotNull(message="UserName is Mandatory")
	private String username;
	
	@Size(min=5,max=8)
	@NotNull(message="Entering Password is Mandatory")
	@Pattern(regexp = "[789][0-9]{9}",message = "Enter valid mobile phone number")
	private String password;
	private String role;

	

}

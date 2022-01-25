package com.cg.webapp.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer adminId;
	
	private String name;

	private String username;
	
	private String password;
	
	
	
	
}

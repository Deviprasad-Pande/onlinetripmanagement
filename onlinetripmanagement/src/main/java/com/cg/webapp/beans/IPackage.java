package com.cg.webapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPackage {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer packageId;
	
	private String packageName;
	
	private String packageDescription;
	
	private Double packageCost;
	
	private Integer numberOfPackages;
	
	private Integer availability;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Merchant merchant;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Customer> customer=new ArrayList<Customer>();


	


	
	}
	
	
	
	
	
	


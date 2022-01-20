package com.cg.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.webapp.beans.IPackage;

public interface PackageRepository extends JpaRepository<IPackage, Integer>{

	

}

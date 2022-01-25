package com.cg.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.webapp.beans.IAdmin;

public interface AdminRepository extends JpaRepository<IAdmin,Integer>{

}

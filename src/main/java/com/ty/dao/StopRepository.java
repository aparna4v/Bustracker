package com.ty.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.dto.Bus;
import com.ty.dto.Stop;

public interface StopRepository extends JpaRepository<Stop, Integer>{
	
	
	

}

package com.ty.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.dto.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	
	@Query("SELECT b FROM Bus b " +
		       "WHERE LOWER(:stop1) IN (SELECT LOWER(s1.stopname) FROM Stop s1 WHERE s1.bus = b) " +
		       "AND LOWER(:stop2) IN (SELECT LOWER(s2.stopname) FROM Stop s2 WHERE s2.bus = b)")
		List<Bus> getbusbystopnameIgnoreCase(@Param("stop1") String stop1,
		                                     @Param("stop2") String stop2);

      

}

package com.pepsi.rh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


import com.pepsi.rh.entities.Absences;

public interface IAbsence extends JpaRepository<Absences, Long>{
	@Query(value = "SELECT * FROM Absences abs WHERE abs.datePremierJ >=:PJ AND abs.dateDernierJ<= :DJ",nativeQuery=true)
	public List<Absences> findAbsrncesPeriode(@Param("PJ")LocalDateTime PJ,@Param("DJ")LocalDateTime DJ);
	@Query(value = "SELECT * FROM Absences",nativeQuery=true)
	public List<Absences> findAbsrncesPeriode();

}

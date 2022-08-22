package com.pepsi.rh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pepsi.rh.entities.Blacklist;

public interface IBlacklist extends JpaRepository<Blacklist, Long>{

	Blacklist findByCollaborateurCin(String cin);
}

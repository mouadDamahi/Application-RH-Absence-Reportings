package com.pepsi.rh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pepsi.rh.entities.Collaborateur;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "collaborateur")
public interface ICollaborateur  extends JpaRepository<Collaborateur, Long>{

}

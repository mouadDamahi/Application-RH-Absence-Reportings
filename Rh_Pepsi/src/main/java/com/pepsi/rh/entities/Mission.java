package com.pepsi.rh.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class Mission {
	@Id
	@GeneratedValue
	long id;
	String libelle;
	LocalDate datedebut,datefin;
	@ManyToOne
	Collaborateur collaborateur;
	
	public Collaborateur Collaborateur() {
		return getCollaborateur();
		}

}

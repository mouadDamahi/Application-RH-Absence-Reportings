package com.pepsi.rh.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Fonction {

	@Id
	@GeneratedValue
	long id;
	String libelle;
	LocalDate datedebut;
	@Column(nullable = true)
	LocalDate datedebutfin;
	
	@JsonIgnore
	@ManyToOne
	Collaborateur collaborateur;
	
	public Collaborateur Collaborateur() {
		return getCollaborateur();
	}
}

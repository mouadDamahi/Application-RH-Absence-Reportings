package com.pepsi.rh.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Discipline {
	
	@Id
	@GeneratedValue
	long id;
	String avertissement;
	LocalDate date;
	
	String file;
	@JsonIgnore
	@ManyToOne
	Collaborateur collaborateur;

	public Collaborateur Collaborateur() {
		return getCollaborateur();
	}
}

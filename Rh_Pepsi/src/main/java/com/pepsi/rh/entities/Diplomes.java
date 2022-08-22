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
public class Diplomes {

	@Id
	@GeneratedValue
	long id;
	String libelle;
	LocalDate date;
	@JsonIgnore
	@ManyToOne
	Collaborateur collaborateur;
	public Collaborateur Collaborateur() {
		return getCollaborateur();
	}
}

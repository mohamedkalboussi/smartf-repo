package org.glsid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmploye;
	
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "id_employe_sup")
	private Employe employeSup; // association reflexive
	
	@ManyToMany
	@JoinTable(name = "EMP_GRP")
	private Collection<Groupe> groupes;

	public Employe() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonIgnore // import com.fasterxml.jackson.annotation.JsonIgnore;
	public Employe getEmployeSup() {
		return employeSup;
	}

	@JsonSetter // import com.fasterxml.jackson.annotation.JsonSetter;
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}

	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
}
package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupastudencka")
public class GrupaStudencka implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idGrupy")
	@GeneratedValue
	private String idGrupy;

	@Column(name = "rok")
	private Integer rok;

	@ManyToOne
	@JoinColumn(name = "Kierunek_idKierunku", referencedColumnName="idKierunku", nullable = false)
	private Kierunek idKierunku;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "grupastudencka_student",
            joinColumns = @JoinColumn(name = "idGrupy"),
            inverseJoinColumns = @JoinColumn(name = "Student_id")
    )
	
	public String getIdGrupy() {
		return idGrupy;
	}

	public void setIdGrupy(String idGrupy) {
		this.idGrupy = idGrupy;
	}

	public Integer getRok() {
		return rok;
	}

	public void setRok(Integer rok) {
		this.rok = rok;
	}

	public Kierunek getIdKierunku() {
		return idKierunku;
	}

	public void setIdKierunku(Kierunek idKierunku) {
		this.idKierunku = idKierunku;
	}
}

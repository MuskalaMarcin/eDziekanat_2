package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wydzial")
public class Wydzial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idWydzialu")
	@GeneratedValue
	private Integer idWydzialu;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "adres")
	private String adres;

	@Column(name = "Uczelnia_idUczelni")
	private Uczelnia uczelniaIdUczelni;

	public Integer getIdWydzialu() {
		return idWydzialu;
	}

	public void setIdWydzialu(Integer idWydzialu) {
		this.idWydzialu = idWydzialu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Uczelnia getUczelniaIdUczelni() {
		return uczelniaIdUczelni;
	}

	public void setUczelniaIdUczelni(Uczelnia uczelniaIdUczelni) {
		this.uczelniaIdUczelni = uczelniaIdUczelni;
	}
}

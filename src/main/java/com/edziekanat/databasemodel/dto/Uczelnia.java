package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uczelnia")
public class Uczelnia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUczelni")
	@GeneratedValue
	private Integer idUczelni;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "adres")
	private String adres;

	public Integer getIdUczelni() {
		return idUczelni;
	}

	public void setIdUczelni(Integer idUczelni) {
		this.idUczelni = idUczelni;
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

}

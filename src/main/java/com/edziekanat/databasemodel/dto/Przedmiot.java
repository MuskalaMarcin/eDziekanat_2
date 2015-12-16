package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "przedmiot")
public class Przedmiot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer idPrzedmiotu;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "semestr")
	private Integer semestr;

	@Column(name = "ects")
	private Integer ects;

	@Column(name = "Pracowniknaukowodydaktyczny_id")
	private PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId;

	public Integer getIdPrzedmiotu() {
		return idPrzedmiotu;
	}

	public void setIdPrzedmiotu(Integer idPrzedmiotu) {
		this.idPrzedmiotu = idPrzedmiotu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Integer getSemestr() {
		return semestr;
	}

	public void setSemestr(Integer semestr) {
		this.semestr = semestr;
	}

	public Integer getEcts() {
		return ects;
	}

	public void setEcts(Integer ects) {
		this.ects = ects;
	}

	public PracownikNaukowoDydaktyczny getPracownikNaukowoDydaktycznyId() {
		return pracownikNaukowoDydaktycznyId;
	}

	public void setPracownikNaukowoDydaktycznyId(PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId) {
		this.pracownikNaukowoDydaktycznyId = pracownikNaukowoDydaktycznyId;
	}

}

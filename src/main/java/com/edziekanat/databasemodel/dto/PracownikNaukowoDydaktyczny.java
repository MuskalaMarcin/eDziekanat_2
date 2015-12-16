package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pracowniknaukowodydaktyczny")
public class PracownikNaukowoDydaktyczny implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "id")
	private String nazwisko;

	@Column(name = "adres")
	private String adres;

	@Column(name = "stopienNaukowy")
	private String stopienNaukowy;

	@Column(name = "stanowisko")
	private String stanowisko;

	@Column(name = "Uczelnia_idUczelni")
	private Uczelnia uczelniaIdUczelni;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getStopienNaukowy() {
		return stopienNaukowy;
	}

	public void setStopienNaukowy(String stopienNaukowy) {
		this.stopienNaukowy = stopienNaukowy;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public Uczelnia getUczelniaIdUczelni() {
		return uczelniaIdUczelni;
	}

	public void setUczelniaIdUczelni(Uczelnia uczelniaIdUczelni) {
		this.uczelniaIdUczelni = uczelniaIdUczelni;
	}

}

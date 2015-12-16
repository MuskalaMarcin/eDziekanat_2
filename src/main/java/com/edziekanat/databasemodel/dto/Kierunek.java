package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kierunek")
public class Kierunek implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idKierunku")
	@GeneratedValue
	private Integer idKierunku;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "stacjonarne")
	private boolean stacjonarne;

	@Column(name = "Wydzial_idWydzialu")
	private Wydzial wydzialIdWydzialu;

	public Integer getIdKierunku() {
		return idKierunku;
	}

	public void setIdKierunku(Integer idKierunku) {
		this.idKierunku = idKierunku;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public boolean isStacjonarne() {
		return stacjonarne;
	}

	public void setStacjonarne(boolean stacjonarne) {
		this.stacjonarne = stacjonarne;
	}

	public Wydzial getWydzialIdWydzialu() {
		return wydzialIdWydzialu;
	}

	public void setWydzialIdWydzialu(Wydzial wydzialIdWydzialu) {
		this.wydzialIdWydzialu = wydzialIdWydzialu;
	}
}

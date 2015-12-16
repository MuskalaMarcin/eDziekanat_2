package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salazajeciowa")
public class SalaZajeciowa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "numerSali")
	@GeneratedValue
	private Integer numerSali;

	@Column(name = "pojemnosc")
	private Integer pojemnosc;

	@Column(name = "typ")
	private String typ;

	@Column(name = "Wydzial_idWydzialu")
	private Wydzial wydzialIdWydzialu;

	public Integer getNumerSali() {
		return numerSali;
	}

	public void setNumerSali(Integer numerSali) {
		this.numerSali = numerSali;
	}

	public Integer getPojemnosc() {
		return pojemnosc;
	}

	public void setPojemnosc(Integer pojemnosc) {
		this.pojemnosc = pojemnosc;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public Wydzial getWydzialIdWydzialu() {
		return wydzialIdWydzialu;
	}

	public void setWydzialIdWydzialu(Wydzial wydzialIdWydzialu) {
		this.wydzialIdWydzialu = wydzialIdWydzialu;
	}
}

package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne
	@JoinColumn(name = "Wydzial_idWydzialu", referencedColumnName="idWydzialu", nullable = false)
	private Wydzial wydzialIdWydzialu;

	@OneToMany(mappedBy = "salaZajeciowaNumerSali")
	private Set<ZaplanowaneZajecia> zaplanowaneZajecia;
	
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

	public Set<ZaplanowaneZajecia> getZaplanowaneZajecia() {
		return zaplanowaneZajecia;
	}

	public void setZaplanowaneZajecia(Set<ZaplanowaneZajecia> zaplanowaneZajecia) {
		this.zaplanowaneZajecia = zaplanowaneZajecia;
	}
	
}

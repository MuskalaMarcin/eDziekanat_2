package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wpis")
public class Wpis implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idWpisu")
	@GeneratedValue
	private Integer idWpisu;

	@Column(name = "ocena")
	private Float ocena;

	@Column(name = "data")
	private Date data;

	@Column(name = "semestr")
	private Integer semestr;

	@ManyToOne
	@JoinColumn(name = "Przedmiot_idPrzedmiotu", referencedColumnName = "idPrzedmiotu", nullable = false)
	private Przedmiot przedmiotIdPrzedmiotu;

	@ManyToOne
	@JoinColumn(name = "Indeks_idIndeksu", referencedColumnName = "idIndeksu", nullable = false)
	private Indeks indeksIdIndeksu;

	public Integer getIdWpisu() {
		return idWpisu;
	}

	public void setIdWpisu(Integer idWpisu) {
		this.idWpisu = idWpisu;
	}

	public Float getOcena() {
		return ocena;
	}

	public void setOcena(Float ocena) {
		this.ocena = ocena;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getSemestr() {
		return semestr;
	}

	public void setSemestr(Integer semestr) {
		this.semestr = semestr;
	}

	public Przedmiot getPrzedmiotIdPrzedmiotu() {
		return przedmiotIdPrzedmiotu;
	}

	public void setPrzedmiotIdPrzedmiotu(Przedmiot przedmiotIdPrzedmiotu) {
		this.przedmiotIdPrzedmiotu = przedmiotIdPrzedmiotu;
	}

	public Indeks getIndeksIdIndeksu() {
		return indeksIdIndeksu;
	}

	public void setIndeksIdIndeksu(Indeks indeksIdIndeksu) {
		this.indeksIdIndeksu = indeksIdIndeksu;
	}

}

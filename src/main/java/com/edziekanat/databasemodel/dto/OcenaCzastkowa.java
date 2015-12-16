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
@Table(name = "ocenaCzastkowa")
public class OcenaCzastkowa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idOceny")
	@GeneratedValue
	private Integer idOceny;

	@Column(name = "Ocena")
	private Float Ocena;

	@Column(name = "dataWystawienia")
	private Date dataWystawienia;

	@Column(name = "semestr")
	private Integer semestr;

	@ManyToOne
	@JoinColumn(name = "Przedmiot_idPrzedmiotu", referencedColumnName="idPrzedmiotu", nullable = false)
	private Przedmiot przedmiotIdPrzedmiotu;

	@ManyToOne
	@JoinColumn(name = "Indeks_idIndeksu", referencedColumnName="idIndeksu", nullable = false)
	private Indeks indeksIdIndeksu;

	public Integer getIdOceny() {
		return idOceny;
	}

	public void setIdOceny(Integer idOceny) {
		this.idOceny = idOceny;
	}

	public Float getOcena() {
		return Ocena;
	}

	public void setOcena(Float ocena) {
		Ocena = ocena;
	}

	public Date getDataWystawienia() {
		return dataWystawienia;
	}

	public void setDataWystawienia(Date dataWystawienia) {
		this.dataWystawienia = dataWystawienia;
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

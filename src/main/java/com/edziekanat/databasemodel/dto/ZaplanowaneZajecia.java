package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zaplanowanezajecia")
public class ZaplanowaneZajecia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idZajec")
	@GeneratedValue
	private Integer idZajec;

	@Column(name = "data")
	private Date data;

	@Column(name = "Salazajeciowa_numerSali")
	private SalaZajeciowa salaZajeciowaNumerSali;

	@Column(name = "Przedmiot_idPrzedmiotu")
	private Przedmiot przedmiotIdPzedmiotu;

	public Integer getIdZajec() {
		return idZajec;
	}

	public void setIdZajec(Integer idZajec) {
		this.idZajec = idZajec;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public SalaZajeciowa getSalaZajeciowaNumerSali() {
		return salaZajeciowaNumerSali;
	}

	public void setSalaZajeciowaNumerSali(SalaZajeciowa salaZajeciowaNumerSali) {
		this.salaZajeciowaNumerSali = salaZajeciowaNumerSali;
	}

	public Przedmiot getPrzedmiotIdPzedmiotu() {
		return przedmiotIdPzedmiotu;
	}

	public void setPrzedmiotIdPzedmiotu(Przedmiot przedmiotIdPzedmiotu) {
		this.przedmiotIdPzedmiotu = przedmiotIdPzedmiotu;
	}

}

package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stypendium")
public class Stypendium implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "numerSali")
	@GeneratedValue
	private Integer idStypendium;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "wysokosc")
	private Float wysokosc;

	@Column(name = "dataPrzyznania")
	private Date dataPrzyznania;

	@Column(name = "dataZakonczenia")
	private Date dataZakonczenia;

	@Column(name = "Student_id")
	private Student studentId;

	public Integer getIdStypendium() {
		return idStypendium;
	}

	public void setIdStypendium(Integer idStypendium) {
		this.idStypendium = idStypendium;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Float getWysokosc() {
		return wysokosc;
	}

	public void setWysokosc(Float wysokosc) {
		this.wysokosc = wysokosc;
	}

	public Date getDataPrzyznania() {
		return dataPrzyznania;
	}

	public void setDataPrzyznania(Date dataPrzyznania) {
		this.dataPrzyznania = dataPrzyznania;
	}

	public Date getDataZakonczenia() {
		return dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

}

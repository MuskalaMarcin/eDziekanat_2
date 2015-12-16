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
@Table(name = "naleznosc")
public class Naleznosc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idNaleznosci")
	@GeneratedValue
	private Integer idNaleznosci;

	@Column(name = "opis")
	private String opis;

	@Column(name = "kwota")
	private Float kwota;

	@Column(name = "dataWystawienia")
	private Date dataWystawienia;

	@Column(name = "dataWplaty")
	private Date dataWplaty;

	@ManyToOne
	@JoinColumn(name = "Student_id", referencedColumnName="idStudenta", nullable = false)
	private Student studentId;

	public Integer getIdNaleznosci() {
		return idNaleznosci;
	}

	public void setIdNaleznosci(Integer idNaleznosci) {
		this.idNaleznosci = idNaleznosci;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Float getKwota() {
		return kwota;
	}

	public void setKwota(Float kwota) {
		this.kwota = kwota;
	}

	public Date getDataWystawienia() {
		return dataWystawienia;
	}

	public void setDataWystawienia(Date dataWystawienia) {
		this.dataWystawienia = dataWystawienia;
	}

	public Date getDataWplaty() {
		return dataWplaty;
	}

	public void setDataWplaty(Date dataWplaty) {
		this.dataWplaty = dataWplaty;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}
}

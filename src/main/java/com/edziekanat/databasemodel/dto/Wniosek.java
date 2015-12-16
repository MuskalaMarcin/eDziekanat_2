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
@Table(name = "wniosek")
public class Wniosek implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idWniosku")
	@GeneratedValue
	private Integer idWniosku;

	@Column(name = "tytul")
	private String tytul;

	@Column(name = "opis")
	private String opis;

	@Column(name = "dataNadania")
	private Date dataNadania;

	@Column(name = "statusPrzyjecia")
	private boolean statusPrzyjecia;

	@ManyToOne
	@JoinColumn(name = "Student_id", referencedColumnName = "idStudenta", nullable = false)
	private Student studentId;

	public Integer getIdWniosku() {
		return idWniosku;
	}

	public void setIdWniosku(Integer idWniosku) {
		this.idWniosku = idWniosku;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDataNadania() {
		return dataNadania;
	}

	public void setDataNadania(Date dataNadania) {
		this.dataNadania = dataNadania;
	}

	public boolean isStatusPrzyjecia() {
		return statusPrzyjecia;
	}

	public void setStatusPrzyjecia(boolean statusPrzyjecia) {
		this.statusPrzyjecia = statusPrzyjecia;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

}

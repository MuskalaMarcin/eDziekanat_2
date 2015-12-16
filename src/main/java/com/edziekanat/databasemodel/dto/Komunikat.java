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
@Table(name = "komunikat")
public class Komunikat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idKomunikatu")
	@GeneratedValue
	private Integer idKomunikatu;

	@Column(name = "tytul")
	private String tytul;

	@Column(name = "tresc")
	private String tresc;

	@Column(name = "dataNadania")
	private Date dataNadania;

	@ManyToOne
	@JoinColumn(name = "Student_id", referencedColumnName="idStudenta", nullable = true)
	private Student studentId;

	@ManyToOne
	@JoinColumn(name = "Pracowniknaukowodydaktyczny_id", referencedColumnName="idPracownika", nullable = true)
	private PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId;

	@ManyToOne
	@JoinColumn(name = "Administrator_id", referencedColumnName="idAdministratora", nullable = true)
	private Administrator administratorId;

	public Integer getIdKomunikatu() {
		return idKomunikatu;
	}

	public void setIdKomunikatu(Integer idKomunikatu) {
		this.idKomunikatu = idKomunikatu;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getTresc() {
		return tresc;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	public Date getDataNadania() {
		return dataNadania;
	}

	public void setDataNadania(Date dataNadania) {
		this.dataNadania = dataNadania;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public PracownikNaukowoDydaktyczny getPracownikNaukowoDydaktycznyId() {
		return pracownikNaukowoDydaktycznyId;
	}

	public void setPracownikNaukowoDydaktycznyId(PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId) {
		this.pracownikNaukowoDydaktycznyId = pracownikNaukowoDydaktycznyId;
	}

	public Administrator getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(Administrator administratorId) {
		this.administratorId = administratorId;
	}

}

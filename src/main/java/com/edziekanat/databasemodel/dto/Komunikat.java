package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Column(name = "Student_id")
	private Student studentId;

	@Column(name = "Pracowniknaukowodydaktyczny_id")
	private PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId;

	@Column(name = "Administrator_id")
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

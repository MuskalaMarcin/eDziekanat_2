package com.edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "indeks")
public class Indeks implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int idIndeksu;

	@Column(name = "dataWydania")
	private int dataWydania;

	@ManyToOne
	@JoinColumn(name = "Student_id", referencedColumnName="idStudenta", nullable = false)
	private Student studentId;

	public int getIdIndeksu() {
		return idIndeksu;
	}

	public void setIdIndeksu(int idIndeksu) {
		this.idIndeksu = idIndeksu;
	}

	public int getDataWydania() {
		return dataWydania;
	}

	public void setDataWydania(int dataWydania) {
		this.dataWydania = dataWydania;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

}

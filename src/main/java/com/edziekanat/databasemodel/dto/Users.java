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
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username")
	@GeneratedValue
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "administrator_id", referencedColumnName = "idAdministratora", nullable = true)
	private Administrator administratorId;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "idStudenta", nullable = true)
	private Student StudentId;

	@ManyToOne
	@JoinColumn(name = "pracowniknaukowodydaktyczny_id", referencedColumnName = "idPracownika", nullable = true)
	private PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId;

	@Column(name = "enabled")
	private Integer enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrator getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(Administrator administratorId) {
		this.administratorId = administratorId;
	}

	public Student getStudentId() {
		return StudentId;
	}

	public void setStudentId(Student studentId) {
		StudentId = studentId;
	}

	public PracownikNaukowoDydaktyczny getPracownikNaukowoDydaktycznyId() {
		return pracownikNaukowoDydaktycznyId;
	}

	public void setPracownikNaukowoDydaktycznyId(PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId) {
		this.pracownikNaukowoDydaktycznyId = pracownikNaukowoDydaktycznyId;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
}

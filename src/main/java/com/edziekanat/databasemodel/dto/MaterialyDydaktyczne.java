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
@Table(name = "materialydydaktyczne")
public class MaterialyDydaktyczne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idKomunikatu")
	@GeneratedValue
	private Integer idMaterialu;

	@Column(name = "opis")
	private String opis;

	@ManyToOne
	@JoinColumn(name = "Przedmiot_idPrzedmiotu", referencedColumnName="idPrzedmiotu", nullable = false)
	private Przedmiot przedmiotIdPrzedmiotu;

	public Integer getIdMaterialu() {
		return idMaterialu;
	}

	public void setIdMaterialu(Integer idMaterialu) {
		this.idMaterialu = idMaterialu;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Przedmiot getPrzedmiotIdPrzedmiotu() {
		return przedmiotIdPrzedmiotu;
	}

	public void setPrzedmiotIdPrzedmiotu(Przedmiot przedmiotIdPrzedmiotu) {
		this.przedmiotIdPrzedmiotu = przedmiotIdPrzedmiotu;
	}

}

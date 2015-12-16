package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "uczelnia")
public class Uczelnia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUczelni")
	@GeneratedValue
	private Integer idUczelni;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "adres")
	private String adres;

	public Integer getIdUczelni() {
		return idUczelni;
	}

	@OneToMany(mappedBy = "uczelniaIdUczelni")
	private Set<Wydzial> wydzialy;

	@OneToMany(mappedBy = "uczelniaIdUczelni")
	private Set<Administrator> administratorzy;

	public void setIdUczelni(Integer idUczelni) {
		this.idUczelni = idUczelni;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Set<Wydzial> getWydzialy() {
		return wydzialy;
	}

	public void setWydzialy(Set<Wydzial> wydzialy) {
		this.wydzialy = wydzialy;
	}

	public Set<Administrator> getAdministratorzy() {
		return administratorzy;
	}

	public void setAdministratorzy(Set<Administrator> administratorzy) {
		this.administratorzy = administratorzy;
	}

}

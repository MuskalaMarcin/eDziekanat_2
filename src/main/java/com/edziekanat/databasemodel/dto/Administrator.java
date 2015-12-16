package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idAdministratora")
	@GeneratedValue
	private Integer id;

	@Column(name = "imie")
	private String imie;
	
	@Column(name = "nazwisko")
	private String nazwisko;
	
	@Column(name = "adres")
	private String adres;

	@ManyToOne
	@JoinColumn(name = "Uczelnia_idUczelni", referencedColumnName="idUczelni", nullable = false)
	private Uczelnia uczelniaIdUczelni;
	
	@OneToMany(mappedBy = "administratorId")
	private Set<Komunikat> komunikaty;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Uczelnia getUczelniaIdUczelni() {
		return uczelniaIdUczelni;
	}

	public void setUczelniaIdUczelni(Uczelnia uczelniaIdUczelni) {
		this.uczelniaIdUczelni = uczelniaIdUczelni;
	}

	public Set<Komunikat> getKomunikaty() {
		return komunikaty;
	}

	public void setKomunikaty(Set<Komunikat> komunikaty) {
		this.komunikaty = komunikaty;
	}
	
}

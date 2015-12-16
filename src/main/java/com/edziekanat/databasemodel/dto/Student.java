package com.edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idStudenta")
	@GeneratedValue
	private Integer id;

	@Column(name = "imie")
	private String imie;

	@Column(name = "nazwisko")
	private String nazwisko;

	@Column(name = "stopienNaukowy")
	private String stopienNaukowy;

	@Column(name = "adres")
	private String adres;
	
	@OneToMany(mappedBy = "studentId")
	private Set<Stypendium> stypendia;
	
	@OneToMany(mappedBy = "studentId")
	private Set<Wniosek> wnioski;
	
	@OneToMany(mappedBy = "studentId")
	private Set<Naleznosc> naleznosci;
	
	@OneToMany(mappedBy = "studentId")
	private Set<Komunikat> komunikaty;
	
	@OneToMany(mappedBy = "studentId")
	private Set<Indeks> indeksy;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "grupastudencka_student",
            joinColumns = @JoinColumn(name = "idStudenta", referencedColumnName = "Student_id"),
            inverseJoinColumns = @JoinColumn(name = "idGrupy")
    )
	
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

	public String getStopienNaukowy() {
		return stopienNaukowy;
	}

	public void setStopienNaukowy(String stopienNaukowy) {
		this.stopienNaukowy = stopienNaukowy;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Set<Stypendium> getStypendia() {
		return stypendia;
	}

	public void setStypendia(Set<Stypendium> stypendia) {
		this.stypendia = stypendia;
	}

	public Set<Wniosek> getWnioski() {
		return wnioski;
	}

	public void setWnioski(Set<Wniosek> wnioski) {
		this.wnioski = wnioski;
	}

	public Set<Naleznosc> getNaleznosci() {
		return naleznosci;
	}

	public void setNaleznosci(Set<Naleznosc> naleznosci) {
		this.naleznosci = naleznosci;
	}

	public Set<Komunikat> getKomunikaty() {
		return komunikaty;
	}

	public void setKomunikaty(Set<Komunikat> komunikaty) {
		this.komunikaty = komunikaty;
	}

	public Set<Indeks> getIndeksy() {
		return indeksy;
	}

	public void setIndeksy(Set<Indeks> indeksy) {
		this.indeksy = indeksy;
	}
	
}

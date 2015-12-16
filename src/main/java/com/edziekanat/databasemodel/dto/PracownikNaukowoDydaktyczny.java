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
@Table(name = "pracowniknaukowodydaktyczny")
public class PracownikNaukowoDydaktyczny implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPracownika")
	@GeneratedValue
	private Integer id;

	@Column(name = "id")
	private String nazwisko;

	@Column(name = "adres")
	private String adres;

	@Column(name = "stopienNaukowy")
	private String stopienNaukowy;

	@Column(name = "stanowisko")
	private String stanowisko;

	@OneToMany(mappedBy = "pracownikNaukowoDydaktycznyId")
	private Set<Przedmiot> przedmioty;
	
	@OneToMany(mappedBy = "pracownikNaukowoDydaktycznyId")
	private Set<Komunikat> komunikaty;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "wydzial_pracowniknaukowodydaktyczny",
            joinColumns = @JoinColumn(name="idPracownika", referencedColumnName = "Pracowniknaukowodydaktyczny_id"),
            inverseJoinColumns = @JoinColumn(name = "idWydzialu")
    )
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStopienNaukowy() {
		return stopienNaukowy;
	}

	public void setStopienNaukowy(String stopienNaukowy) {
		this.stopienNaukowy = stopienNaukowy;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public Set<Przedmiot> getPrzedmioty() {
		return przedmioty;
	}

	public void setPrzedmioty(Set<Przedmiot> przedmioty) {
		this.przedmioty = przedmioty;
	}

	public Set<Komunikat> getKomunikaty() {
		return komunikaty;
	}

	public void setKomunikaty(Set<Komunikat> komunikaty) {
		this.komunikaty = komunikaty;
	}

}

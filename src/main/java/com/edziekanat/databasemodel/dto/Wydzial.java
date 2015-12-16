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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wydzial")
public class Wydzial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idWydzialu")
	@GeneratedValue
	private Integer idWydzialu;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "adres")
	private String adres;

	@ManyToOne
	@JoinColumn(name = "Uczelnia_idUczelni", referencedColumnName = "idUczelni", nullable = false)
	private Uczelnia uczelniaIdUczelni;
	
	@OneToMany(mappedBy = "wydzialIdWydzialu")
	private Set<Kierunek> kierunki;
	
	@OneToMany(mappedBy = "wydzialIdWydzialu")
	private Set<SalaZajeciowa> saleZajeciowe;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "wydzial_pracowniknaukowodydaktyczny",
            joinColumns = @JoinColumn(name = "idWydzialu"),
            inverseJoinColumns = @JoinColumn(name = "Pracowniknaukowodydaktyczny_id")
    )
	
	public Integer getIdWydzialu() {
		return idWydzialu;
	}

	public void setIdWydzialu(Integer idWydzialu) {
		this.idWydzialu = idWydzialu;
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

	public Uczelnia getUczelniaIdUczelni() {
		return uczelniaIdUczelni;
	}

	public void setUczelniaIdUczelni(Uczelnia uczelniaIdUczelni) {
		this.uczelniaIdUczelni = uczelniaIdUczelni;
	}

	public Set<Kierunek> getKierunki() {
		return kierunki;
	}

	public void setKierunki(Set<Kierunek> kierunki) {
		this.kierunki = kierunki;
	}

	public Set<SalaZajeciowa> getSaleZajeciowe() {
		return saleZajeciowe;
	}

	public void setSaleZajeciowe(Set<SalaZajeciowa> saleZajeciowe) {
		this.saleZajeciowe = saleZajeciowe;
	}
	
}

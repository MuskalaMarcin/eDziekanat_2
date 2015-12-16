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
@Table(name = "przedmiot")
public class Przedmiot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer idPrzedmiotu;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "semestr")
	private Integer semestr;

	@Column(name = "ects")
	private Integer ects;

	@ManyToOne
	@JoinColumn(name = "Pracowniknaukowodydaktyczny_id", referencedColumnName="idPracownika", nullable = false)
	private PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId;

	@OneToMany(mappedBy = "przedmiotIdPzedmiotu")
	private Set<ZaplanowaneZajecia> zaplanowaneZajecia;
	
	@OneToMany(mappedBy = "przedmiotIdPrzedmiotu")
	private Set<Wpis> wpisy;
	
	@OneToMany(mappedBy = "przedmiotIdPrzedmiotu")
	private Set<OcenaCzastkowa> ocenyCzastkowe;
	
	@OneToMany(mappedBy = "przedmiotIdPrzedmiotu")
	private Set<MaterialyDydaktyczne> materialyDydaktyczne;
	
	public Integer getIdPrzedmiotu() {
		return idPrzedmiotu;
	}

	public void setIdPrzedmiotu(Integer idPrzedmiotu) {
		this.idPrzedmiotu = idPrzedmiotu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Integer getSemestr() {
		return semestr;
	}

	public void setSemestr(Integer semestr) {
		this.semestr = semestr;
	}

	public Integer getEcts() {
		return ects;
	}

	public void setEcts(Integer ects) {
		this.ects = ects;
	}

	public PracownikNaukowoDydaktyczny getPracownikNaukowoDydaktycznyId() {
		return pracownikNaukowoDydaktycznyId;
	}

	public void setPracownikNaukowoDydaktycznyId(PracownikNaukowoDydaktyczny pracownikNaukowoDydaktycznyId) {
		this.pracownikNaukowoDydaktycznyId = pracownikNaukowoDydaktycznyId;
	}

	public Set<ZaplanowaneZajecia> getZaplanowaneZajecia() {
		return zaplanowaneZajecia;
	}

	public void setZaplanowaneZajecia(Set<ZaplanowaneZajecia> zaplanowaneZajecia) {
		this.zaplanowaneZajecia = zaplanowaneZajecia;
	}

	public Set<Wpis> getWpisy() {
		return wpisy;
	}

	public void setWpisy(Set<Wpis> wpisy) {
		this.wpisy = wpisy;
	}

	public Set<OcenaCzastkowa> getOcenyCzastkowe() {
		return ocenyCzastkowe;
	}

	public void setOcenyCzastkowe(Set<OcenaCzastkowa> ocenyCzastkowe) {
		this.ocenyCzastkowe = ocenyCzastkowe;
	}

	public Set<MaterialyDydaktyczne> getMaterialyDydaktyczne() {
		return materialyDydaktyczne;
	}

	public void setMaterialyDydaktyczne(Set<MaterialyDydaktyczne> materialyDydaktyczne) {
		this.materialyDydaktyczne = materialyDydaktyczne;
	}

}

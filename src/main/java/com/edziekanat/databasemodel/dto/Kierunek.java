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
@Table(name = "kierunek")
public class Kierunek implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idKierunku")
	@GeneratedValue
	private Integer idKierunku;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "stacjonarne")
	private boolean stacjonarne;

	@ManyToOne
	@JoinColumn(name = "Wydzial_idWydzialu", referencedColumnName="idWydzialu", nullable = false)
	private Wydzial wydzialIdWydzialu;

	@OneToMany(mappedBy = "idKierunku")
	private Set<GrupaStudencka> grupyStudenckie;
	
	public Integer getIdKierunku() {
		return idKierunku;
	}

	public void setIdKierunku(Integer idKierunku) {
		this.idKierunku = idKierunku;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public boolean isStacjonarne() {
		return stacjonarne;
	}

	public void setStacjonarne(boolean stacjonarne) {
		this.stacjonarne = stacjonarne;
	}

	public Wydzial getWydzialIdWydzialu() {
		return wydzialIdWydzialu;
	}

	public void setWydzialIdWydzialu(Wydzial wydzialIdWydzialu) {
		this.wydzialIdWydzialu = wydzialIdWydzialu;
	}

	public Set<GrupaStudencka> getGrupyStudenckie() {
		return grupyStudenckie;
	}

	public void setGrupyStudenckie(Set<GrupaStudencka> grupyStudenckie) {
		this.grupyStudenckie = grupyStudenckie;
	}
	
}

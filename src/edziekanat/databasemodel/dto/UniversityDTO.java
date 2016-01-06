package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="university")
public class UniversityDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	
	public UniversityDTO(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

}

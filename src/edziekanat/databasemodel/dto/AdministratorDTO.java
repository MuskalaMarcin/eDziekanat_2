package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class AdministratorDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="address")
	private String address;
	@Column(name="position")
	private String position;
	@Column(name="university_id")
	private Integer university_id;
	
	public AdministratorDTO(Integer id, String name, String surname, String address, String position,
			Integer university_id) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.position = position;
		this.university_id = university_id;
	}

}

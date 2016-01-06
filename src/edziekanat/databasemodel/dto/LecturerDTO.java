package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lecturer")
public class LecturerDTO {
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
	
	public LecturerDTO(Integer id, String name, String surname, String address, String position) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.position = position;
	}

}

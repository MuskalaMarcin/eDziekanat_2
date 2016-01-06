package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class FacultyDTO {
	@Id
    @Column(name="id")
	private Integer id;
    @Column(name="name")
	private String name;
    @Column(name="address")
	private String address;
    @Column(name="university_id")
	private Integer university_id;
	
	public FacultyDTO(Integer id, String name, String address, Integer university_id) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.university_id = university_id;
	}

}

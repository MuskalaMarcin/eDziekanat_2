package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="academic_degree")
	private String academic_degree;
	@Column(name="address")
	private String address;
	
	public StudentDTO(Integer id, String name, String surname, String academic_degree, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.academic_degree = academic_degree;
		this.address = address;
	}

}

package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class CourseDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="stationary")
	private Integer stationary;
	@Column(name="faculty_id")
	private Integer faculty_id;
	
	public CourseDTO(Integer id, String name, Integer stationary, Integer faculty_id) {
		this.id = id;
		this.name = name;
		this.stationary = stationary;
		this.faculty_id = faculty_id;
	}
}

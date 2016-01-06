package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classroom")
public class ClassroomDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="capacity")
	private Integer capacity;
	@Column(name="type")
	private String type;
	@Column(name="faculty_id")
	private Integer faculty_id;
	
	public ClassroomDTO(Integer id, Integer capacity, String type, Integer faculty_id) {
		this.id = id;
		this.capacity = capacity;
		this.type = type;
		this.faculty_id = faculty_id;
	}
}

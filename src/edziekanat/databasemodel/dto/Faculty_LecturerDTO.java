package edziekanat.databasemodel.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="faculty_lecturer")
public class Faculty_LecturerDTO {
	private Integer faculty_id;
	private Integer lecturer_id;
	
	public Faculty_LecturerDTO(Integer faculty_id, Integer lecturer_id) {
		this.faculty_id = faculty_id;
		this.lecturer_id = lecturer_id;
	}

}

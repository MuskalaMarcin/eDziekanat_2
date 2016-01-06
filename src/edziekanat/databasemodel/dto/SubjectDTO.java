package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class SubjectDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="semester")
	private Integer semester;
	@Column(name="ects")
	private Integer ECTS;
	@Column(name="lecturer_id")
	private Integer lecturer_id;
	
	public SubjectDTO(Integer id, String name, Integer semester, Integer eCTS, Integer lecturer_id) {
		this.id = id;
		this.name = name;
		this.semester = semester;
		ECTS = eCTS;
		this.lecturer_id = lecturer_id;
	}

}

package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students_group")
public class Students_GroupDTO {
	@Id
    @Column(name="id")
	private Integer id;
    @Column(name="year")
	private Integer year;
    @Column(name="course_id")
	private Integer course_id;
	
	public Students_GroupDTO(Integer id, Integer year, Integer course_id) {
		this.id = id;
		this.year = year;
		this.course_id = course_id;
	}

}

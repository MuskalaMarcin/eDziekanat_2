package edziekanat.databasemodel.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="students_group_student")
public class Students_Group_StudentDTO {
	private Integer students_group_id;
	private Integer student_id;
	
	public Students_Group_StudentDTO(Integer students_group_id, Integer student_id) {
		this.students_group_id = students_group_id;
		this.student_id = student_id;
	}

}

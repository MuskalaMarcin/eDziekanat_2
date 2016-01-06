package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transcript")
public class TranscriptDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="issue_date")
	private Date issue_date;
	@Column(name="student_id")
	private Integer student_id;
	@Column(name="students_group_id")
	private Integer students_group_id;
	
	public TranscriptDTO(Integer id, Date issue_date, Integer student_id, Integer students_group_id) {
		this.id = id;
		this.issue_date = issue_date;
		this.student_id = student_id;
		this.students_group_id = students_group_id;
	}

	
	
}

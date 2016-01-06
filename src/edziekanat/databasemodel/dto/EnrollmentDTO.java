package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enrollment")
public class EnrollmentDTO {
	@Id
    @Column(name="id")
	private Integer id;
    @Column(name="mark")
	private Float mark;
    @Column(name="issue_date")
	private Date issue_date;
    @Column(name="subject_id")
	private Integer subject_id;
    @Column(name="transcript_id")
	private Integer transcript_id;
	
	public EnrollmentDTO(Integer id, Float mark, Date issue_date, Integer subject_id, Integer transcript_id) {
		this.id = id;
		this.mark = mark;
		this.issue_date = issue_date;
		this.subject_id = subject_id;
		this.transcript_id = transcript_id;
	}
}

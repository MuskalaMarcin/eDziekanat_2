package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schollarship")
public class ScholarshipDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="grant_date")
	private Date grant_date;
	@Column(name="end_date")
	private Date end_date;
	@Column(name="schollarship_type")
	private String scholarship_type;
	@Column(name="student_id")
	private Integer student_id;
	@Column(name="administrator_id")
	private Integer administrator_id;
	
	public ScholarshipDTO(Integer id, Date grant_date, Date end_date, String scholarship_type, Integer student_id,
			Integer administrator_id) {
		this.id = id;
		this.grant_date = grant_date;
		this.end_date = end_date;
		this.scholarship_type = scholarship_type;
		this.student_id = student_id;
		this.administrator_id = administrator_id;
	}

}

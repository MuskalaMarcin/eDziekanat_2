package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class ApplicationDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="dispatch_date")
	private Date dispatch_date;
	@Column(name="receive_date")
	private Date receive_date;
	@Column(name="student_id")
	private Integer student_id;
	@Column(name="administrator_id")
	private Integer administrator_id;
	
	public ApplicationDTO(Integer id, String title, String content, Date dispatch_date, Date receive_date,
			Integer student_id, Integer administrator_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.dispatch_date = dispatch_date;
		this.receive_date = receive_date;
		this.student_id = student_id;
		this.administrator_id = administrator_id;
	}
	

}

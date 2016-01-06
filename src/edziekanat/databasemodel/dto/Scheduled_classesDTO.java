package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scheduled_classes")
public class Scheduled_classesDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="date")
	private Date date;
	@Column(name="time")
	private Date time;
	@Column(name="duration")
	private Integer duration;
	@Column(name="classroom_id")
	private Integer classroom_id;
	@Column(name="subject_id")
	private Integer subject_id;
	
	public Scheduled_classesDTO(Integer id, Date date, Date time, Integer duration, Integer classroom_id,
			Integer subject_id) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.classroom_id = classroom_id;
		this.subject_id = subject_id;
	}

}

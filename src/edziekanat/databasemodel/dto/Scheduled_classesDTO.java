package edziekanat.databasemodel.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "scheduled_classes")
public class Scheduled_classesDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Time time;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "classroom_id")
    private Integer classroom_id;
    @Column(name = "subject_id")
    private Integer subject_id;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Date getDate()
    {
	return date;
    }

    public void setDate(Date date)
    {
	this.date = date;
    }

    public Time getTime()
    {
	return time;
    }

    public void setTime(Time time)
    {
	this.time = time;
    }

    public Integer getDuration()
    {
	return duration;
    }

    public void setDuration(Integer duration)
    {
	this.duration = duration;
    }

    public Integer getClassroom_id()
    {
	return classroom_id;
    }

    public void setClassroom_id(Integer classroom_id)
    {
	this.classroom_id = classroom_id;
    }

    public Integer getSubject_id()
    {
	return subject_id;
    }

    public void setSubject_id(Integer subject_id)
    {
	this.subject_id = subject_id;
    }
}

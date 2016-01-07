package edziekanat.databasemodel.dto;

import java.io.Serializable;
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
public class ScheduledClassesDTO implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private Time time;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "classroom_id")
    private Integer classroomId;
    @Column(name = "subject_id")
    private Integer subjectId;

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
	return classroomId;
    }

    public void setClassroom_id(Integer classroom_id)
    {
	this.classroomId = classroom_id;
    }

    public Integer getSubject_id()
    {
	return subjectId;
    }

    public void setSubject_id(Integer subject_id)
    {
	this.subjectId = subject_id;
    }
}

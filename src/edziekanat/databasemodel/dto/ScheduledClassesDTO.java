package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.SCHEDULED_CLASSES)
public class ScheduledClassesDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="scheduled_classes_id_seq")
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private Time time;
    @Column(name = "duration")
    private Integer duration;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private ClassroomDTO classroom;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectDTO subject;

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

    public ClassroomDTO getClassroom()
    {
        return classroom;
    }

    public void setClassroom(ClassroomDTO classroom)
    {
        this.classroom = classroom;
    }

    public SubjectDTO getSubject()
    {
        return subject;
    }

    public void setSubject(SubjectDTO subject)
    {
        this.subject = subject;
    }
}

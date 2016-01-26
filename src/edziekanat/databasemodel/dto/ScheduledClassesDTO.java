package edziekanat.databasemodel.dto;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edziekanat.databasemodel.TableNames;

/**
 *  Data transfer object representing scheduled classes entity.
 *
 */
@Entity
@Table(name = TableNames.SCHEDULED_CLASSES)
public class ScheduledClassesDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SCHEDULEDCLASSESSEQ", sequenceName = "scheduled_classes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SCHEDULEDCLASSESSEQ")
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "classes_date")
    private Date date;
    @Column(name = "duration")
    private Integer duration;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private ClassroomDTO classroom;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
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

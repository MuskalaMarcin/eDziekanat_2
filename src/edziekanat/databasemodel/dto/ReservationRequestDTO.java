package edziekanat.databasemodel.dto;

import edziekanat.databasemodel.TableNames;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Marcin Muska³a on 09.05.2016.
 */
@Entity
@Table(name = TableNames.RESERVATION_REQUEST)
public class ReservationRequestDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "RESERVATIONREQUESTSEQ", sequenceName = "reservation_request_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RESERVATIONREQUESTSEQ")
    @Column(name = "id")
    private Integer id;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectDTO subject;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private ClassroomDTO classroom;
    @Temporal(TemporalType.DATE)
    @Column(name = "request_date")
    private Date requestDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "classes_date")
    private Date classesDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "classes_end_date")
    private Date classesEndDate;
    @Column(name = "repeat_classes")
    private Integer repeatClasses;
    @Column(name = "status")
    private String status;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public SubjectDTO getSubject()
    {
	return subject;
    }

    public void setSubject(SubjectDTO subject)
    {
	this.subject = subject;
    }

    public ClassroomDTO getClassroom()
    {
	return classroom;
    }

    public void setClassroom(ClassroomDTO classroom)
    {
	this.classroom = classroom;
    }

    public Date getRequestDate()
    {
	return requestDate;
    }

    public void setRequestDate(Date requestDate)
    {
	this.requestDate = requestDate;
    }

    public Date getClassesDate()
    {
	return classesDate;
    }

    public void setClassesDate(Date classesDate)
    {
	this.classesDate = classesDate;
    }

    public Date getClassesEndDate()
    {
	return classesEndDate;
    }

    public void setClassesEndDate(Date classesEndDate)
    {
	this.classesEndDate = classesEndDate;
    }

    public Integer getRepeatClasses()
    {
	return repeatClasses;
    }

    public void setRepeatClasses(Integer repeatClasses)
    {
	this.repeatClasses = repeatClasses;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }
}

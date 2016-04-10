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
 *  Data transfer object representing application entity.
 *
 */
@Entity
@Table(name = TableNames.APPLICATION)
public class ApplicationDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "APPLICATIONSEQ", sequenceName = "application_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "APPLICATIONSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Temporal(TemporalType.DATE)
    @Column(name = "dispatch_date")
    private Date dispatchDate;
    @Column(name = "status")
    private String status;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentDTO student;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id")
    private AdministratorDTO administrator;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "application_type_id")
    private Application_typeDTO application_type;


    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getTitle()
    {
	return title;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    public String getContent()
    {
	return content;
    }

    public void setContent(String content)
    {
	this.content = content;
    }

    public Date getDispatchDate()
    {
	return dispatchDate;
    }

    public void setDispatchDate(Date dispatch_date)
    {
	this.dispatchDate = dispatch_date;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public StudentDTO getStudent()
    {
	return student;
    }

    public void setStudent(StudentDTO student)
    {
	this.student = student;
    }

    public AdministratorDTO getAdministrator()
    {
	return administrator;
    }

    public void setAdministrator(AdministratorDTO administrator)
    {
	this.administrator = administrator;
    }

    public Application_typeDTO getApplication_type(){return application_type;}

    public void setApplication_type(Application_typeDTO application_type){this.application_type = application_type;}
}

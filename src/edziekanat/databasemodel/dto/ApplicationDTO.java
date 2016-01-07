package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.APPLICATION)
public class ApplicationDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Temporal(TemporalType.DATE)
    @Column(name = "dispatch_date")
    private Date dispatchDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "receive_date")
    private Date receiveDate;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "administrator_id")
    private Integer administratorId;

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

    public Date getReceiveDate()
    {
	return receiveDate;
    }

    public void setReceiveDate(Date receive_date)
    {
	this.receiveDate = receive_date;
    }

    public Integer getStudentId()
    {
	return studentId;
    }

    public void setStudentId(Integer student_id)
    {
	this.studentId = student_id;
    }

    public Integer getAdministratorId()
    {
	return administratorId;
    }

    public void setAdministratorId(Integer administrator_id)
    {
	this.administratorId = administrator_id;
    }
}

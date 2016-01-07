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
@Table(name = TableNames.SCHOLARSHIP)
public class ScholarshipDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "grant_date")
    private Date grantDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "schollarship_type")
    private String scholarshipType;
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

    public Date getGrant_date()
    {
	return grantDate;
    }

    public void setGrant_date(Date grant_date)
    {
	this.grantDate = grant_date;
    }

    public Date getEnd_date()
    {
	return endDate;
    }

    public void setEnd_date(Date end_date)
    {
	this.endDate = end_date;
    }

    public String getScholarship_type()
    {
	return scholarshipType;
    }

    public void setScholarship_type(String scholarship_type)
    {
	this.scholarshipType = scholarship_type;
    }

    public Integer getStudent_id()
    {
	return studentId;
    }

    public void setStudent_id(Integer student_id)
    {
	this.studentId = student_id;
    }

    public Integer getAdministrator_id()
    {
	return administratorId;
    }

    public void setAdministrator_id(Integer administrator_id)
    {
	this.administratorId = administrator_id;
    }
}

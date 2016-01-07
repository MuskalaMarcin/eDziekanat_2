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

    public Date getGrantDate()
    {
	return grantDate;
    }

    public void setGrantDate(Date grantDate)
    {
	this.grantDate = grantDate;
    }

    public Date getEndDate()
    {
	return endDate;
    }

    public void setEndDate(Date endDate)
    {
	this.endDate = endDate;
    }

    public String getScholarshipType()
    {
	return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType)
    {
	this.scholarshipType = scholarshipType;
    }

    public Integer getStudentId()
    {
	return studentId;
    }

    public void setStudentId(Integer studentId)
    {
	this.studentId = studentId;
    }

    public Integer getAdministratorId()
    {
	return administratorId;
    }

    public void setAdministratorId(Integer administratorId)
    {
	this.administratorId = administratorId;
    }
}

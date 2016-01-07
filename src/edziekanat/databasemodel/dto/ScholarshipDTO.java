package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "schollarship")
public class ScholarshipDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "grant_date")
    private Date grant_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "schollarship_type")
    private String scholarship_type;
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "administrator_id")
    private Integer administrator_id;

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
	return grant_date;
    }

    public void setGrant_date(Date grant_date)
    {
	this.grant_date = grant_date;
    }

    public Date getEnd_date()
    {
	return end_date;
    }

    public void setEnd_date(Date end_date)
    {
	this.end_date = end_date;
    }

    public String getScholarship_type()
    {
	return scholarship_type;
    }

    public void setScholarship_type(String scholarship_type)
    {
	this.scholarship_type = scholarship_type;
    }

    public Integer getStudent_id()
    {
	return student_id;
    }

    public void setStudent_id(Integer student_id)
    {
	this.student_id = student_id;
    }

    public Integer getAdministrator_id()
    {
	return administrator_id;
    }

    public void setAdministrator_id(Integer administrator_id)
    {
	this.administrator_id = administrator_id;
    }
}

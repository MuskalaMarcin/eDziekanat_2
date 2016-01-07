package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transcript")
public class TranscriptDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    private Date issue_date;
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "students_group_id")
    private Integer students_group_id;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Date getIssue_date()
    {
	return issue_date;
    }

    public void setIssue_date(Date issue_date)
    {
	this.issue_date = issue_date;
    }

    public Integer getStudent_id()
    {
	return student_id;
    }

    public void setStudent_id(Integer student_id)
    {
	this.student_id = student_id;
    }

    public Integer getStudents_group_id()
    {
	return students_group_id;
    }

    public void setStudents_group_id(Integer students_group_id)
    {
	this.students_group_id = students_group_id;
    }
}

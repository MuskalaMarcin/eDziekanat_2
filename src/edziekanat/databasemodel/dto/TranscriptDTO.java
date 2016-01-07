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
@Table(name = TableNames.TRANSCRIPT)
public class TranscriptDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    private Date issueDate;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "students_group_id")
    private Integer studentsGroupId;

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
	return issueDate;
    }

    public void setIssue_date(Date issue_date)
    {
	this.issueDate = issue_date;
    }

    public Integer getStudent_id()
    {
	return studentId;
    }

    public void setStudent_id(Integer student_id)
    {
	this.studentId = student_id;
    }

    public Integer getStudents_group_id()
    {
	return studentsGroupId;
    }

    public void setStudents_group_id(Integer students_group_id)
    {
	this.studentsGroupId = students_group_id;
    }
}

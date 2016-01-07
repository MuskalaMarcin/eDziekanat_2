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

    public Date getIssueDate()
    {
	return issueDate;
    }

    public void setIssueDate(Date issue_date)
    {
	this.issueDate = issue_date;
    }

    public Integer getStudentId()
    {
	return studentId;
    }

    public void setStudentId(Integer student_id)
    {
	this.studentId = student_id;
    }

    public Integer getStudentsGroupId()
    {
	return studentsGroupId;
    }

    public void setStudentsGroupId(Integer students_group_id)
    {
	this.studentsGroupId = students_group_id;
    }
}

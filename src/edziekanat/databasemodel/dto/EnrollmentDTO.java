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
@Table(name = TableNames.ENROLLMENT)
public class EnrollmentDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "mark")
    private Float mark;
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    private Date issueDate;
    @Column(name = "subject_id")
    private Integer subjectId;
    @Column(name = "transcript_id")
    private Integer transcriptId;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Float getMark()
    {
	return mark;
    }

    public void setMark(Float mark)
    {
	this.mark = mark;
    }

    public Date getIssue_date()
    {
	return issueDate;
    }

    public void setIssue_date(Date issue_date)
    {
	this.issueDate = issue_date;
    }

    public Integer getSubject_id()
    {
	return subjectId;
    }

    public void setSubject_id(Integer subject_id)
    {
	this.subjectId = subject_id;
    }

    public Integer getTranscript_id()
    {
	return transcriptId;
    }

    public void setTranscript_id(Integer transcript_id)
    {
	this.transcriptId = transcript_id;
    }
}

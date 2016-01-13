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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="enrollment_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "mark")
    private Float mark;
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    private Date issueDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectDTO subjectId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "transcript_id")
    private TranscriptDTO transcriptId;

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

    public Date getIssueDate()
    {
	return issueDate;
    }

    public void setIssueDate(Date issue_date)
    {
	this.issueDate = issue_date;
    }

    public SubjectDTO getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(SubjectDTO subjectId)
    {
        this.subjectId = subjectId;
    }

    public TranscriptDTO getTranscriptId()
    {
        return transcriptId;
    }

    public void setTranscriptId(TranscriptDTO transcriptId)
    {
        this.transcriptId = transcriptId;
    }
}

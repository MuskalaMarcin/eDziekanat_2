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
 *  Data transfer object representing partial mark entity.
 *
 */
@Entity
@Table(name = TableNames.PARTIAL_MARK)
public class PartialMarkDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PARTIALMARKSEQ", sequenceName = "partial_mark_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PARTIALMARKSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "mark")
    private Float mark;
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    private Date issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectDTO subject;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "transcript_id")
    private TranscriptDTO transcript;

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

    public void setIssueDate(Date issueDate)
    {
	this.issueDate = issueDate;
    }

    public SubjectDTO getSubject()
    {
	return subject;
    }

    public void setSubject(SubjectDTO subject)
    {
	this.subject = subject;
    }

    public TranscriptDTO getTranscript()
    {
	return transcript;
    }

    public void setTranscript(TranscriptDTO transcript)
    {
	this.transcript = transcript;
    }
}

package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "partial_mark")
public class Partial_MarkDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "mark")
    private Float mark;
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    private Date issue_date;
    @Column(name = "subject_id")
    private Integer subject_id;
    @Column(name = "transcript_id")
    private Integer transcript_id;
    
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
        return issue_date;
    }
    public void setIssue_date(Date issue_date)
    {
        this.issue_date = issue_date;
    }
    public Integer getSubject_id()
    {
        return subject_id;
    }
    public void setSubject_id(Integer subject_id)
    {
        this.subject_id = subject_id;
    }
    public Integer getTranscript_id()
    {
        return transcript_id;
    }
    public void setTranscript_id(Integer transcript_id)
    {
        this.transcript_id = transcript_id;
    }
}

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

@Entity
@Table(name = TableNames.PASSED_SEMESTER)
public class PassedSemesterDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="PASSED_SEMESTERSEQ",sequenceName="passed_semester_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="PASSED_SEMESTERSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "semester")
    private Integer semester;
    @Temporal(TemporalType.DATE)
    @Column(name = "dispatch_date")
    private Date dispatchDate;
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

    public Integer getSemester()
    {
	return semester;
    }

    public void setSemester(Integer semester)
    {
	this.semester = semester;
    }

    public Date getDispatchDate()
    {
	return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate)
    {
	this.dispatchDate = dispatchDate;
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

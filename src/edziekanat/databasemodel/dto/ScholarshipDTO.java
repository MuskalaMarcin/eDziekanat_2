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
@Table(name = TableNames.SCHOLARSHIP)
public class ScholarshipDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SCHOLARSHIPSEQ",sequenceName="scholarship_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SCHOLARSHIPSEQ")
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "grant_date")
    private Date grantDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "scholarship_type")
    private ScholarshipTypeDTO scholarshipType;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentDTO student;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id")
    private AdministratorDTO administrator;

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

    public ScholarshipTypeDTO getScholarshipType()
    {
        return scholarshipType;
    }

    public void setScholarshipType(ScholarshipTypeDTO scholarshipType)
    {
        this.scholarshipType = scholarshipType;
    }

    public StudentDTO getStudent()
    {
        return student;
    }

    public void setStudentId(StudentDTO student)
    {
        this.student = student;
    }

    public AdministratorDTO getAdministrator()
    {
        return administrator;
    }

    public void setAdministratorId(AdministratorDTO administrator)
    {
        this.administrator = administrator;
    }
}

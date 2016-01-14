package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.STUDENT)
public class StudentDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="STUDENTSEQ",sequenceName="student_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="STUDENTSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "academic_degree")
    private String academicDegree;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<ApplicationDTO> application;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<ScholarshipDTO> scholarship;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<TranscriptDTO> transcript;
    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    private UserDTO user;
    @ManyToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentsGroupDTO> studentsGroup;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getSurname()
    {
	return surname;
    }

    public void setSurname(String surname)
    {
	this.surname = surname;
    }

    public String getAcademicDegree()
    {
	return academicDegree;
    }

    public void setAcademicDegree(String academic_degree)
    {
	this.academicDegree = academic_degree;
    }

    public String getAddress()
    {
	return address;
    }

    public void setAddress(String address)
    {
	this.address = address;
    }

    public List<ApplicationDTO> getApplication()
    {
	return application;
    }

    public void setApplication(List<ApplicationDTO> application)
    {
	this.application = application;
    }

    public List<ScholarshipDTO> getScholarship()
    {
	return scholarship;
    }

    public void setScholarship(List<ScholarshipDTO> scholarship)
    {
	this.scholarship = scholarship;
    }

    public List<TranscriptDTO> getTranscript()
    {
	return transcript;
    }

    public void setTranscript(List<TranscriptDTO> transcript)
    {
	this.transcript = transcript;
    }

    public UserDTO getUser()
    {
	return user;
    }

    public void setUser(UserDTO user)
    {
	this.user = user;
    }

    public List<StudentsGroupDTO> getStudentsGroup()
    {
	return studentsGroup;
    }

    public void setStudentsGroup(List<StudentsGroupDTO> studentsGroup)
    {
	this.studentsGroup = studentsGroup;
    }

}

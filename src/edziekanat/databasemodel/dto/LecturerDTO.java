package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

/**
 *  Data transfer object representing lecturer entity.
 *
 */
@Entity
@Table(name = TableNames.LECTURER)
public class LecturerDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="LECTURERSEQ",sequenceName="lecturer_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="LECTURERSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name = "position")
    private String position;
    @Column(name = "academic_degree")
    private String academicDegree;
    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
    private List<SubjectDTO> subject;
    @OneToOne(mappedBy = "lecturer", fetch = FetchType.LAZY)
    private UserDTO user;
    @ManyToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
    private List<FacultyDTO> faculty;

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

    public String getAddress()
    {
	return address;
    }

    public void setAddress(String address)
    {
	this.address = address;
    }

    public String getPosition()
    {
	return position;
    }

    public void setPosition(String position)
    {
	this.position = position;
    }

    public String getAcademicDegree()
    {
	return academicDegree;
    }

    public void setAcademicDegree(String academicDegree)
    {
	this.academicDegree = academicDegree;
    }

    public List<SubjectDTO> getSubject()
    {
	return subject;
    }

    public void setSubject(List<SubjectDTO> subject)
    {
	this.subject = subject;
    }

    public UserDTO getUser()
    {
	return user;
    }

    public void setUser(UserDTO user)
    {
	this.user = user;
    }

    public List<FacultyDTO> getFaculty()
    {
	return faculty;
    }

    public void setFaculty(List<FacultyDTO> faculty)
    {
	this.faculty = faculty;
    }
}

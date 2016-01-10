package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.ADMINISTRATOR)
public class AdministratorDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private UniversityDTO university;

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

    public UniversityDTO getUniversity()
    {
        return university;
    }

    public void setUniversity(UniversityDTO university)
    {
        this.university = university;
    }
}

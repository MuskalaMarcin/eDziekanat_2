package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

/**
 *  Data transfer object representing university entity.
 *
 */
@Entity
@Table(name = TableNames.UNIVERSITY)
public class UniversityDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="UNIVERSITYSEQ",sequenceName="university_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="UNIVERSITYSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    private List<FacultyDTO> faculty;
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    private List<AdministratorDTO> administrator;

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

    public String getAddress()
    {
	return address;
    }

    public void setAddress(String address)
    {
	this.address = address;
    }

    public List<FacultyDTO> getFaculty()
    {
        return faculty;
    }

    public void setFaculty(List<FacultyDTO> faculty)
    {
        this.faculty = faculty;
    }

    public List<AdministratorDTO> getAdministrator()
    {
        return administrator;
    }

    public void setAdministrator(List<AdministratorDTO> administrator)
    {
        this.administrator = administrator;
    }

}

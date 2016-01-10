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
@Table(name = TableNames.CLASSROOM)
public class ClassroomDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "type")
    private String type;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private FacultyDTO faculty;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Integer getCapacity()
    {
	return capacity;
    }

    public void setCapacity(Integer capacity)
    {
	this.capacity = capacity;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public FacultyDTO getFaculty()
    {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty)
    {
        this.faculty = faculty;
    }
}

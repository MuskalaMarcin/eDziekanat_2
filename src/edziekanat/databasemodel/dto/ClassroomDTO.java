package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classroom")
public class ClassroomDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "type")
    private String type;
    @Column(name = "faculty_id")
    private Integer faculty_id;

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

    public Integer getFaculty_id()
    {
	return faculty_id;
    }

    public void setFaculty_id(Integer faculty_id)
    {
	this.faculty_id = faculty_id;
    }
}

package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_group")
public class Students_GroupDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "course_id")
    private Integer course_id;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Integer getYear()
    {
	return year;
    }

    public void setYear(Integer year)
    {
	this.year = year;
    }

    public Integer getCourse_id()
    {
	return course_id;
    }

    public void setCourse_id(Integer course_id)
    {
	this.course_id = course_id;
    }
}

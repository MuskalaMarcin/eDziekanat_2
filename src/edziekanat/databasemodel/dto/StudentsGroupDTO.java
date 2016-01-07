package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_group")
public class StudentsGroupDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "course_id")
    private Integer courseId;

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
	return courseId;
    }

    public void setCourse_id(Integer course_id)
    {
	this.courseId = course_id;
    }
}

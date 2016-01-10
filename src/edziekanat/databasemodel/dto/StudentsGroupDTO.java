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
@Table(name = TableNames.STUDENTS_GROUP)
public class StudentsGroupDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseDTO course;

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

    public CourseDTO getCourse()
    {
        return course;
    }

    public void setCourse(CourseDTO course)
    {
        this.course = course;
    }
}

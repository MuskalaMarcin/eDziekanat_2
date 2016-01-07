package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_lecturer")
public class FacultyLecturerDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "faculty_id")
    private Integer facultyId;
    @Id
    @Column(name = "lecturer_id")
    private Integer lecturerId;

    public Integer getFaculty_id()
    {
	return facultyId;
    }

    public void setFaculty_id(Integer faculty_id)
    {
	this.facultyId = faculty_id;
    }

    public Integer getLecturer_id()
    {
	return lecturerId;
    }

    public void setLecturer_id(Integer lecturer_id)
    {
	this.lecturerId = lecturer_id;
    }
}

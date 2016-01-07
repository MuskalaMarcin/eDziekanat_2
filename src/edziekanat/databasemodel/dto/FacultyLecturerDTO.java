package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.FACULTY_LECTURER)
public class FacultyLecturerDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "faculty_id")
    private Integer facultyId;
    @Id
    @Column(name = "lecturer_id")
    private Integer lecturerId;

    public Integer getFacultyId()
    {
	return facultyId;
    }

    public void setFacultyId(Integer facultyId)
    {
	this.facultyId = facultyId;
    }

    public Integer getLecturerId()
    {
	return lecturerId;
    }

    public void setLecturerId(Integer lecturerId)
    {
	this.lecturerId = lecturerId;
    }
}

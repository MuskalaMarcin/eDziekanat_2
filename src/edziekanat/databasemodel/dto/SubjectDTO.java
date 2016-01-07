package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.SUBJECT)
public class SubjectDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "semester")
    private Integer semester;
    @Column(name = "ects")
    private Integer ECTS;
    @Column(name = "lecturer_id")
    private Integer lecturerId;
    @Column(name = "students_group_id")
    private Integer studentsGroupId;

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

    public Integer getSemester()
    {
	return semester;
    }

    public void setSemester(Integer semester)
    {
	this.semester = semester;
    }

    public Integer getECTS()
    {
	return ECTS;
    }

    public void setECTS(Integer eCTS)
    {
	ECTS = eCTS;
    }

    public Integer getLecturerId()
    {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId)
    {
        this.lecturerId = lecturerId;
    }

    public Integer getStudentsGroupId()
    {
        return studentsGroupId;
    }

    public void setStudentsGroupId(Integer studentsGroupId)
    {
        this.studentsGroupId = studentsGroupId;
    }
    
    
}

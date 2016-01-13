package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.SUBJECT)
public class SubjectDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subject_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "semester")
    private Integer semester;
    @Column(name = "ects")
    private Integer ECTS;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    private LecturerDTO lecturer;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "students_group_id")
    private StudentsGroupDTO studentsGroup;

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

    public LecturerDTO getLecturer()
    {
	return lecturer;
    }

    public void setLecturer(LecturerDTO lecturer)
    {
	this.lecturer = lecturer;
    }

    public StudentsGroupDTO getStudentsGroup()
    {
	return studentsGroup;
    }

    public void setStudentsGroup(StudentsGroupDTO studentsGroup)
    {
	this.studentsGroup = studentsGroup;
    }
}

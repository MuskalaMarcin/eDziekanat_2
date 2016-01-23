package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.COURSE)
public class CourseDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "COURSESEQ", sequenceName = "course_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "COURSESEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "stationary")
    private Integer stationary;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private FacultyDTO faculty;
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<StudentsGroupDTO> students_group;

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

    public Integer getStationary()
    {
	return stationary;
    }

    public void setStationary(Integer stationary)
    {
	this.stationary = stationary;
    }

    public FacultyDTO getFaculty()
    {
	return faculty;
    }

    public void setFaculty(FacultyDTO faculty)
    {
	this.faculty = faculty;
    }

    public List<StudentsGroupDTO> getStudentsGroup()
    {
	return students_group;
    }

    public void setStudentsGroup(List<StudentsGroupDTO> studentsGroup)
    {
	this.students_group = studentsGroup;
    }
}

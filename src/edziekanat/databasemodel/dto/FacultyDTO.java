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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.FACULTY)
public class FacultyDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="FACULTYSEQ",sequenceName="faculty_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="FACULTYSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private UniversityDTO university;
    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<ClassroomDTO> classroom;
    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<CourseDTO> course;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private List<LecturerDTO> lecturer;

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

    public String getAddress()
    {
	return address;
    }

    public void setAddress(String address)
    {
	this.address = address;
    }

    public UniversityDTO getUniversity()
    {
	return university;
    }

    public void setUniversity(UniversityDTO university)
    {
	this.university = university;
    }

    public List<ClassroomDTO> getClassroom()
    {
	return classroom;
    }

    public void setClassroom(List<ClassroomDTO> classroom)
    {
	this.classroom = classroom;
    }

    public List<CourseDTO> getCourse()
    {
	return course;
    }

    public void setCourse(List<CourseDTO> course)
    {
	this.course = course;
    }

    public List<LecturerDTO> getLecturer()
    {
        return lecturer;
    }

    public void setLecturer(List<LecturerDTO> lecturer)
    {
        this.lecturer = lecturer;
    }

}

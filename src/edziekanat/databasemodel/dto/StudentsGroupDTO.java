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
@Table(name = TableNames.STUDENTS_GROUP)
public class StudentsGroupDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="STUDENTSGROUPSEQ",sequenceName="students_group_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="STUDENTSGROUPSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "semester")
    private Integer semester;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseDTO course;
    @OneToMany(mappedBy = "studentsGroup", fetch = FetchType.LAZY)
    private List<SubjectDTO> subject;
    @OneToMany(mappedBy = "studentsGroup", fetch = FetchType.LAZY)
    private List<TranscriptDTO> transcript;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private List<StudentDTO> student;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Integer getSemester()
    {
	return semester;
    }

    public void setSemester(Integer year)
    {
	this.semester = year;
    }

    public CourseDTO getCourse()
    {
	return course;
    }

    public void setCourse(CourseDTO course)
    {
	this.course = course;
    }

    public List<SubjectDTO> getSubject()
    {
	return subject;
    }

    public void setSubject(List<SubjectDTO> subject)
    {
	this.subject = subject;
    }

    public List<TranscriptDTO> getTranscript()
    {
	return transcript;
    }

    public void setTranscript(List<TranscriptDTO> transcript)
    {
	this.transcript = transcript;
    }

    public List<StudentDTO> getStudent()
    {
	return student;
    }

    public void setStudent(List<StudentDTO> student)
    {
	this.student = student;
    }
}

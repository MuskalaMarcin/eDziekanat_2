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
@Table(name = TableNames.SUBJECT)
public class SubjectDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SUBJECTSEQ",sequenceName="subject_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SUBJECTSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "semester")
    private Integer semester;
    @Column(name = "ects")
    private Integer ECTS;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    private LecturerDTO lecturer;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "students_group_id")
    private StudentsGroupDTO studentsGroup;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<EnrollmentDTO> enrollment;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<LearningMaterialsDTO> learningMaterials;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<PartialMarkDTO> partialMark;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<ScheduledClassesDTO> scheduledClasses;
    
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

    public List<EnrollmentDTO> getEnrollment()
    {
        return enrollment;
    }

    public void setEnrollment(List<EnrollmentDTO> enrollment)
    {
        this.enrollment = enrollment;
    }

    public List<LearningMaterialsDTO> getLearningMaterials()
    {
        return learningMaterials;
    }

    public void setLearningMaterials(List<LearningMaterialsDTO> learningMaterials)
    {
        this.learningMaterials = learningMaterials;
    }

    public List<PartialMarkDTO> getPartialMark()
    {
        return partialMark;
    }

    public void setPartialMark(List<PartialMarkDTO> partialMark)
    {
        this.partialMark = partialMark;
    }

    public List<ScheduledClassesDTO> getScheduledClasses()
    {
        return scheduledClasses;
    }

    public void setScheduledClasses(List<ScheduledClassesDTO> scheduledClasses)
    {
        this.scheduledClasses = scheduledClasses;
    }

}

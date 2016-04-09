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

/**
 *  Data transfer object representing subject entity.
 *
 */
@Entity
@Table(name = TableNames.SUBJECT)
public class SubjectDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SUBJECTSEQ", sequenceName = "subject_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SUBJECTSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "semester")
    private Integer semester;
    @Column(name = "ects")
    private Integer ECTS;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    private LecturerDTO lecturer;
    @ManyToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<StudentsGroupDTO> students_group;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<EnrollmentDTO> enrollment;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<LearningMaterialsDTO> learning_materials;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<PartialMarkDTO> partial_mark;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<ScheduledClassesDTO> scheduled_classes;

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

    public List<StudentsGroupDTO> getStudents_group()
    {
        return students_group;
    }

    public void setStudents_group(List<StudentsGroupDTO> students_group)
    {
        this.students_group = students_group;
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
	return learning_materials;
    }

    public void setLearningMaterials(List<LearningMaterialsDTO> learningMaterials)
    {
	this.learning_materials = learningMaterials;
    }

    public List<PartialMarkDTO> getPartialMark()
    {
	return partial_mark;
    }

    public void setPartialMark(List<PartialMarkDTO> partialMark)
    {
	this.partial_mark = partialMark;
    }

    public List<ScheduledClassesDTO> getScheduledClasses()
    {
	return scheduled_classes;
    }

    public void setScheduledClasses(List<ScheduledClassesDTO> scheduledClasses)
    {
	this.scheduled_classes = scheduledClasses;
    }

}

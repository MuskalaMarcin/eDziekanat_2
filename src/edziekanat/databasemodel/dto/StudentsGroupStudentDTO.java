package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.STUDENTS_GROUP_STUDENT)
public class StudentsGroupStudentDTO implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "students_group_id")
    private Integer studentsGroupId;
    @Id
    @Column(name = "student_id")
    private Integer studentId;

    public Integer getStudentsGroupId()
    {
	return studentsGroupId;
    }

    public void setStudentsGroupId(Integer studentsGroupId)
    {
	this.studentsGroupId = studentsGroupId;
    }

    public Integer getStudentId()
    {
	return studentId;
    }

    public void setStudentId(Integer studentId)
    {
	this.studentId = studentId;
    }
}

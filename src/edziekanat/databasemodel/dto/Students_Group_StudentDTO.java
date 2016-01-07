package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_group_student")
public class Students_Group_StudentDTO
{
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

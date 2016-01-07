package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

/**
 * UserDTO class represents one user from users table.
 */
@Entity
@Table(name = TableNames.USER)
public class UserDTO
{
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "lecturer_id")
    private Integer lecturerId;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "administrator_id")
    private Integer administratorId;

    public String getLogin()
    {
	return login;
    }

    public void setLogin(String login)
    {
	this.login = login;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    public String geteMail()
    {
	return eMail;
    }

    public void seteMail(String eMail)
    {
	this.eMail = eMail;
    }

    public Integer isActive()
    {
	return isActive;
    }

    public void setActive(Integer isActive)
    {
	this.isActive = isActive;
    }

    public String getUserRole()
    {
	return userRole;
    }

    public void setUserRole(String userRole)
    {
	this.userRole = userRole;
    }

    public Integer getLecturerId()
    {
	return lecturerId;
    }

    public void setLecturerId(Integer lecturerId)
    {
	this.lecturerId = lecturerId;
    }

    public Integer getStudentId()
    {
	return studentId;
    }

    public void setStudentId(Integer studentId)
    {
	this.studentId = studentId;
    }

    public Integer getAdministratorId()
    {
	return administratorId;
    }

    public void setAdministratorId(Integer administratorId)
    {
	this.administratorId = administratorId;
    }

}

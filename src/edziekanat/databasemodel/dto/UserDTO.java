package edziekanat.databasemodel.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    @OneToOne(cascade = CascadeType.REMOVE, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id", nullable=true)
    private LecturerDTO lecturer;
    @OneToOne(cascade = CascadeType.REMOVE, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable=true)
    private StudentDTO student;
    @OneToOne(cascade = CascadeType.REMOVE, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id", nullable=true)
    private AdministratorDTO administrator;

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

    public Integer getIsActive()
    {
        return isActive;
    }

    public void setIsActive(Integer isActive)
    {
        this.isActive = isActive;
    }

    public LecturerDTO getLecturer()
    {
        return lecturer;
    }

    public void setLecturer(LecturerDTO lecturer)
    {
        this.lecturer = lecturer;
    }

    public StudentDTO getStudent()
    {
        return student;
    }

    public void setStudent(StudentDTO student)
    {
        this.student = student;
    }

    public AdministratorDTO getAdministrator()
    {
        return administrator;
    }

    public void setAdministrator(AdministratorDTO administrator)
    {
        this.administrator = administrator;
    }
}

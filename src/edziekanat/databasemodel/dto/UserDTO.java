package edziekanat.databasemodel.dto;

import edziekanat.databasemodel.TableNames;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 *  Data transfer object representing user entity.
 *
 */
@Entity
@Table(name = TableNames.USER)
public class UserDTO
{
    @Id
    @Column(name = "login")
    protected String login;
    @Column(name = "password")
    protected String password;
    @Column(name = "salt")
    protected String salt;
    @Column(name = "e_mail")
    protected String eMail;
    @Column(name = "is_active")
    protected Integer isActive;
    @Column(name = "user_role")
    protected String userRole;
    @OneToOne(cascade = CascadeType.REFRESH, optional = true,
	    fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id", nullable = true)
    private LecturerDTO lecturer;
    @OneToOne(cascade = CascadeType.REFRESH, optional = true,
	    fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = true)
    private StudentDTO student;
    @OneToOne(cascade = CascadeType.REFRESH, optional = true,
	    fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id", nullable = true)
    private AdministratorDTO administrator;
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<MessageDTO> send_message;
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private List<MessageDTO> received_message;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<PasswordResetDTO> passwordResets;
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<NewsDTO> news;

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

    public String getSalt()
    {
	return salt;
    }

    public void setSalt(String salt)
    {
	this.salt = salt;
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

    public List<MessageDTO> getSend_message()
    {
	return send_message;
    }

    public void setSend_message(List<MessageDTO> send_message)
    {
	this.send_message = send_message;
    }

    public List<MessageDTO> getReceived_message()
    {
	return received_message;
    }

    public void setReceived_message(List<MessageDTO> received_message)
    {
	this.received_message = received_message;
    }

    public List<PasswordResetDTO> getPasswordResets()
    {
	return passwordResets;
    }

    public void setPasswordResets(List<PasswordResetDTO> passwordResets)
    {
	this.passwordResets = passwordResets;
    }

    public List<NewsDTO> getNews()
    {
	return news;
    }

    public void setNews(List<NewsDTO> news)
    {
	this.news = news;
    }
}

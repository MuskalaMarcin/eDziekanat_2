package edziekanat.databasemodel.dto;

/**
 * UserDTO class represents one user from users table.
 */
public class UserDTO
{
    private String login;
    private String password;
    private String eMail;
    private boolean isActive;
    private String userRole;
    private Integer lecturerId;
    private Integer studentId;
    private Integer administratorId;

    public UserDTO(String login, String password, String eMail, boolean isActive, String userRole, Integer lecturerId,
	    Integer studentId, Integer administratorId)
    {
	this.login = login;
	this.password = password;
	this.eMail = eMail;
	this.isActive = isActive;
	this.userRole = userRole;
	this.lecturerId = lecturerId;
	this.studentId = studentId;
	this.administratorId = administratorId;
    }

    public UserDTO(String login, String password, String eMail, boolean isActive, String userRole, Integer personId)
    {
	this.login = login;
	this.password = password;
	this.eMail = eMail;
	this.isActive = isActive;
	this.userRole = userRole;
	switch (userRole)
	{
	case "admin":
	    this.administratorId = personId;
	    break;
	case "student":
	    this.studentId = personId;
	    break;
	case "lecturer":
	    this.lecturerId = personId;
	    break;
	}
    }

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

    public boolean isActive()
    {
	return isActive;
    }

    public void setActive(boolean isActive)
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

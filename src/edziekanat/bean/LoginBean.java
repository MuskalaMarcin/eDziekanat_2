package edziekanat.bean;

import java.io.Serializable;

public class LoginBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String login;
    private String eMail;
    private Integer isActive;
    private String userRole;
    private Integer personId;
    private String name;
    private String surname;
    private String address;
    private String academicDegree;

    public LoginBean()
    {
	super();
    }

    public LoginBean(String login, String eMail, Integer isActive, String userRole, Integer personId,
	    String name, String surname, String address, String academicDegree)
    {
	super();
	this.login = login;
	this.eMail = eMail;
	this.isActive = isActive;
	this.userRole = userRole;
	this.personId = personId;
	this.name = name;
	this.surname = surname;
	this.address = address;
	this.academicDegree = academicDegree;
    }

    public String getLogin()
    {
	return login;
    }

    public void setLogin(String login)
    {
	this.login = login;
    }

    public String geteMail()
    {
	return eMail;
    }

    public void seteMail(String eMail)
    {
	this.eMail = eMail;
    }

    public Integer getIsActive()
    {
	return isActive;
    }

    public void setIsActive(Integer isActive)
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

    public Integer getPersonId()
    {
	return personId;
    }

    public void setPersonId(Integer personId)
    {
	this.personId = personId;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getSurname()
    {
	return surname;
    }

    public void setSurname(String surname)
    {
	this.surname = surname;
    }

    public String getAddress()
    {
	return address;
    }

    public void setAddress(String address)
    {
	this.address = address;
    }

    public String getAcademicDegree()
    {
	return academicDegree;
    }

    public void setAcademicDegree(String academicDegree)
    {
	this.academicDegree = academicDegree;
    }
}

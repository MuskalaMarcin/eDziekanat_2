package edziekanat.bean.student;

import java.io.Serializable;
import java.util.List;

public class LecturerBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String login;
    private List<String> subject;
    private String name;
    private String surname;
    private String eMail;
    private String position;
    private String academicDegree;
    
    public LecturerBean(){
	super();
    }
    
    public LecturerBean(String login, List<String> subject, String name, String surname, String eMail, String position,
	    String academicDegree)
    {
	super();
	this.login = login;
	this.subject = subject;
	this.name = name;
	this.surname = surname;
	this.eMail = eMail;
	this.position = position;
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

    public List<String> getSubject()
    {
        return subject;
    }

    public void setSubject(List<String> subject)
    {
        this.subject = subject;
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

    public String geteMail()
    {
        return eMail;
    }

    public void seteMail(String eMail)
    {
        this.eMail = eMail;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
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

package edziekanat.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import edziekanat.databasemodel.dto.UserDTO;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    private UserDTO user;
    private String login;
    private String password;

    public UserDTO getUser()
    {
	return user;
    }

    public void setUser(UserDTO user)
    {
	this.user = user;
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
    

}

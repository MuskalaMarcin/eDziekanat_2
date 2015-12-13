package edziekanat.servlet.users;

public abstract class AbstractUser
{
    protected String login;
    protected String password;
    protected boolean loggedIn;
    protected UserType userType;

    public AbstractUser(String login, String password, UserType userType)
    {
	this.login=login;
	this.password=password;
	this.userType = userType;
	this.loggedIn = true;
    }

    public boolean getLoginStatus()
    {
	return loggedIn;
    }

    public UserType getUserType()
    {
	return userType;
    }
}

package edziekanat.servlet.users;

public class Administrator extends AbstractUser
{

    public Administrator(String login, String password, UserType userType)
    {
	super(login, password, userType);
    }

}

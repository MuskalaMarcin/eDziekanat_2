package edziekanat.servlet.users;

public class Lecturer extends AbstractUser{

    public Lecturer(String login, String password, UserType userType)
    {
	super(login, password, userType);
    }

}

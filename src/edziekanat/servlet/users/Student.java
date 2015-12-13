package edziekanat.servlet.users;

public class Student extends AbstractUser{

    public Student(String login, String password, UserType userType)
    {
	super(login, password, userType);
    }

}

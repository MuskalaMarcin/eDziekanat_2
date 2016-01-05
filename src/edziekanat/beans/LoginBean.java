package edziekanat.beans;

import javax.annotation.ManagedBean;

import edziekanat.databasemodel.dto.UserDTO;

@ManagedBean(value="loginBean")
public class LoginBean
{
    UserDTO user;
}

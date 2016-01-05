package edziekanat.beans;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import edziekanat.databasemodel.dto.UserDTO;

@ManagedBean
@SessionScoped
public class LoginBean
{
    UserDTO user;
}

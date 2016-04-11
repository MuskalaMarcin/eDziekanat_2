package edziekanat.databasemodel.dto;

import edziekanat.databasemodel.TableNames;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Marcin Muskala on 10.04.2016.
 */
@Entity
@Table(name = TableNames.PASSWORD_RESET)
public class PasswordResetDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "is_active")
    private Integer isActive;
    @Temporal(TemporalType.DATE)
    @Column(name = "request_date")
    private Date requestDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_login")
    private UserDTO user;

    public UserDTO getUser()
    {
	return user;
    }

    public void setUser(UserDTO user)
    {
	this.user = user;
    }

    public Date getRequestDate()
    {
	return requestDate;
    }

    public void setRequestDate(Date requestDate)
    {
	this.requestDate = requestDate;
    }

    public Integer getIsActive()
    {
	return isActive;
    }

    public void setIsActive(Integer isActive)
    {
	this.isActive = isActive;
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }
}

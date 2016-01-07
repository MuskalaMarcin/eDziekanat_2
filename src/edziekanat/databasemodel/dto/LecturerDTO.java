package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lecturer")
public class LecturerDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name = "position")
    private String position;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
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

    public String getPosition()
    {
	return position;
    }

    public void setPosition(String position)
    {
	this.position = position;
    }
}

package edziekanat.databasemodel.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schollarship_type")
public class Scholarship_TypeDTO implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private String type;
    @Column(name = "requirements")
    private String requirements;
    @Column(name = "amount")
    private Float amount;

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getRequirements()
    {
	return requirements;
    }

    public void setRequirements(String requirements)
    {
	this.requirements = requirements;
    }

    public Float getAmount()
    {
	return amount;
    }

    public void setAmount(Float amount)
    {
	this.amount = amount;
    }
}

package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

/**
 *  Data transfer object representing scholarship type entity.
 *
 */
@Entity
@Table(name = TableNames.SCHOLARSHIP_TYPE)
public class ScholarshipTypeDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "type")
    private String type;
    @Column(name = "requirements")
    private String requirements;
    @Column(name = "amount", columnDefinition = "NUMERIC (8,2)")
    private Float amount;
    @OneToMany(mappedBy = "scholarshipType", fetch = FetchType.LAZY)
    private List<ScholarshipDTO> scholarship;

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

    public List<ScholarshipDTO> getScholarship()
    {
        return scholarship;
    }

    public void setScholarship(List<ScholarshipDTO> scholarship)
    {
        this.scholarship = scholarship;
    }
}

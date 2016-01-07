package edziekanat.databasemodel.dto;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.LEARNING_MATERIALS)
public class LearningMaterialsDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "file")
    private File file;
    @Column(name = "subject_id")
    private Integer subjectId;

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

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public File getFile()
    {
	return file;
    }

    public void setFile(File file)
    {
	this.file = file;
    }

    public Integer getSubjectId()
    {
	return subjectId;
    }

    public void setSubjectId(Integer subject_id)
    {
	this.subjectId = subject_id;
    }
}

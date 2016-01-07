package edziekanat.databasemodel.dto;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "learning_materials")
public class Learning_MaterialsDTO
{
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
    private Integer subject_id;

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

    public Integer getSubject_id()
    {
	return subject_id;
    }

    public void setSubject_id(Integer subject_id)
    {
	this.subject_id = subject_id;
    }
}

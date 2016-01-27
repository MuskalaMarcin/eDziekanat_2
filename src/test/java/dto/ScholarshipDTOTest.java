package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.ScholarshipTypeDTO;
import edziekanat.databasemodel.dto.StudentDTO;

public class ScholarshipDTOTest
{
    ScholarshipDTO schol;

    @Before
    public void setUp()
    {
	this.schol = new ScholarshipDTO();
    }

    @Test
    public void testGetId()
    {
	schol.setId(1);
	final int id = schol.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	schol.setId(1);
	final int id = schol.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetGrantDate()
    {
	Date date = new Date();
	schol.setGrantDate(date);
	final Date datetested = schol.getGrantDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetGrantDate()
    {
	Date date = new Date();
	schol.setGrantDate(date);
	final Date datetested = schol.getGrantDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetEndDate()
    {
	Date date = new Date();
	schol.setEndDate(date);
	final Date datetested = schol.getEndDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetEndDate()
    {
	Date date = new Date();
	schol.setEndDate(date);
	final Date datetested = schol.getEndDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetScholarshipType()
    {
	ScholarshipTypeDTO schtype = new ScholarshipTypeDTO();
	schol.setScholarshipType(schtype);
	ScholarshipTypeDTO tested = schol.getScholarshipType();
	assertEquals(schtype, tested);
    }

    @Test
    public void testSetScholarshipType()
    {
	ScholarshipTypeDTO schtype = new ScholarshipTypeDTO();
	schol.setScholarshipType(schtype);
	ScholarshipTypeDTO tested = schol.getScholarshipType();
	assertEquals(schtype, tested);
    }

    @Test
    public void testGetStudent()
    {
	StudentDTO uni = new StudentDTO();
	schol.setStudentId(uni);
	StudentDTO unitest = schol.getStudent();
	assertEquals(uni, unitest);
    }

    @Test
    public void testSetStudentId()
    {
	StudentDTO uni = new StudentDTO();
	schol.setStudentId(uni);
	StudentDTO unitest = schol.getStudent();
	assertEquals(uni, unitest);
    }

    @Test
    public void testGetAdministrator()
    {
	AdministratorDTO uni = new AdministratorDTO();
	schol.setAdministratorId(uni);
	AdministratorDTO unitest = schol.getAdministrator();
	assertEquals(uni, unitest);
    }

    @Test
    public void testSetAdministratorId()
    {
	AdministratorDTO uni = new AdministratorDTO();
	schol.setAdministratorId(uni);
	AdministratorDTO unitest = schol.getAdministrator();
	assertEquals(uni, unitest);
    }

}

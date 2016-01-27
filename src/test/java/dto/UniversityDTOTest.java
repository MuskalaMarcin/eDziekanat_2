package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.UniversityDTO;

public class UniversityDTOTest
{
    UniversityDTO univ;

    @Before
    public void setUp() throws Exception
    {
	this.univ = new UniversityDTO();
    }

    @Test
    public void testGetId()
    {
	univ.setId(1);
	final int id = univ.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	univ.setId(1);
	final int id = univ.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetName()
    {
	univ.setName("foo");
	final String name = univ.getName();
	assertEquals("foo", name);
    }

    @Test
    public void testSetName()
    {
	univ.setName("foo");
	final String name = univ.getName();
	assertEquals("foo", name);
    }

    @Test
    public void testGetAddress()
    {
	univ.setAddress("address");
	final String address = univ.getAddress();
	assertEquals("address", address);
    }

    @Test
    public void testSetAddress()
    {
	univ.setAddress("address");
	final String address = univ.getAddress();
	assertEquals("address", address);
    }

    @Test
    public void testGetFaculty()
    {
	List<FacultyDTO> faculty = new LinkedList<FacultyDTO>();
	univ.setFaculty(faculty);
	List<FacultyDTO> tested = univ.getFaculty();
	assertEquals(faculty, tested);
    }

    @Test
    public void testSetFaculty()
    {
	List<FacultyDTO> faculty = new LinkedList<FacultyDTO>();
	univ.setFaculty(faculty);
	List<FacultyDTO> tested = univ.getFaculty();
	assertEquals(faculty, tested);
    }

    @Test
    public void testGetAdministrator()
    {
	List<AdministratorDTO> uni = new LinkedList<AdministratorDTO>();
	univ.setAdministrator(uni);
	List<AdministratorDTO> unitest = univ.getAdministrator();
	assertEquals(uni, unitest);
    }

    @Test
    public void testSetAdministrator()
    {
	List<AdministratorDTO> uni = new LinkedList<AdministratorDTO>();
	univ.setAdministrator(uni);
	List<AdministratorDTO> unitest = univ.getAdministrator();
	assertEquals(uni, unitest);
    }

}

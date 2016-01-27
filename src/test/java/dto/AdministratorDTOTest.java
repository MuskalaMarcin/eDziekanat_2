package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.UniversityDTO;
import edziekanat.databasemodel.dto.UserDTO;

public class AdministratorDTOTest 
{

    AdministratorDTO admin;
    
    @Before
    public void setUp()
    {
	this.admin = new AdministratorDTO();
    }
    
    @Test
    public void testGetId()
    {
	admin.setId(1);
	final int id = admin.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	admin.setId(1);
	final int id = admin.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetName()
    {
	admin.setName("foo");
	final String name = admin.getName();
	assertEquals("Niezgodne imiê!", "foo", name);
    }

    @Test
    public void testSetName()
    {
	admin.setName("foo");
	final String name = admin.getName();
	assertEquals("Niezgodne imiê!", "foo", name);
    }

    @Test
    public void testGetSurname()
    {
	admin.setSurname("foo");
	final String surname = admin.getSurname();
	assertEquals("Niezgodne nazwisko!", "foo", surname);
    }

    @Test
    public void testSetSurname()
    {
	admin.setSurname("foo");
	final String surname = admin.getSurname();
	assertEquals("Niezgodne nazwisko!", "foo", surname);
    }

    @Test
    public void testGetAddress()
    {
	admin.setAddress("address");
	final String tested = admin.getAddress();
	assertEquals("Niezgodny adres!", "address", tested);
    }

    @Test
    public void testSetAddress()
    {
	admin.setAddress("address");
	final String tested = admin.getAddress();
	assertEquals("Niezgodny adres!", "address", tested);
    }

    @Test
    public void testGetPosition()
    {
	admin.setPosition("pos");
	final String tested = admin.getPosition();
	assertEquals("Niezgodne stanowisko!", "pos", tested);
    }

    @Test
    public void testSetPosition()
    {
	admin.setPosition("pos");
	final String tested = admin.getPosition();
	assertEquals("Niezgodne stanowisko!", "pos", tested);
    }

    @Test
    public void testGetAcademicDegree()
    {
	admin.setAcademicDegree("academicDegree");
	final String tested = admin.getAcademicDegree();
	assertEquals("Niezgodny stopieñ!", "academicDegree", tested);
    }

    @Test
    public void testSetAcademicDegree()
    {
	admin.setAcademicDegree("academicDegree");
	final String tested = admin.getAcademicDegree();
	assertEquals("Niezgodny stopieñ!", "academicDegree", tested);
    }

    @Test
    public void testGetUniversity()
    {
	UniversityDTO uni = new UniversityDTO();
	admin.setUniversity(uni);
	UniversityDTO unitest = admin.getUniversity();
	assertEquals("Niezgodny uniwersytet!", uni, unitest);
    }

    @Test
    public void testSetUniversity()
    {
	UniversityDTO uni = new UniversityDTO();
	admin.setUniversity(uni);
	UniversityDTO unitest = admin.getUniversity();
	assertEquals("Niezgodny uniwersytet!", uni, unitest);
    }

    @Test
    public void testGetApplication()
    {
	List<ApplicationDTO> test = new LinkedList<ApplicationDTO>();
	admin.setApplication(test);
	List<ApplicationDTO> unitest = admin.getApplication();
	assertEquals("Niezgodne wnioski!", test, unitest);
    }

    @Test
    public void testSetApplication()
    {
	List<ApplicationDTO> test = new LinkedList<ApplicationDTO>();
	admin.setApplication(test);
	List<ApplicationDTO> unitest = admin.getApplication();
	assertEquals("Niezgodne wnioski!", test, unitest);
    }

    @Test
    public void testGetScholarship()
    {
	List<ScholarshipDTO> test = new LinkedList<ScholarshipDTO>();
	admin.setScholarship(test);
	List<ScholarshipDTO> unitest = admin.getScholarship();
	assertEquals("Niezgodne stypendia!", test, unitest);
    }

    @Test
    public void testSetScholarship()
    {
	List<ScholarshipDTO> test = new LinkedList<ScholarshipDTO>();
	admin.setScholarship(test);
	List<ScholarshipDTO> unitest = admin.getScholarship();
	assertEquals("Niezgodne stypendia!", test, unitest);
    }

    @Test
    public void testGetUser()
    {
	UserDTO test = new UserDTO();
	admin.setUser(test);
	UserDTO tested = admin.getUser();
	assertEquals("Niezgodny u¿ytownik!", test, tested);
    }

    @Test
    public void testSetUser()
    {
	UserDTO test = new UserDTO();
	admin.setUser(test);
	UserDTO tested = admin.getUser();
	assertEquals("Niezgodny u¿ytownik!", test, tested);
    }

}

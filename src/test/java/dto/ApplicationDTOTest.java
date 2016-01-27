package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.StudentDTO;

public class ApplicationDTOTest
{

    ApplicationDTO app;
    
    @Before
    public void setUp()
    {
	this.app = new ApplicationDTO();
    }
    
    @Test
    public void testGetId()
    {
	app.setId(1);
	final int id = app.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	app.setId(1);
	final int id = app.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetTitle()
    {
	app.setTitle("foo");
	final String title = app.getTitle();
	assertEquals("Z³y tytu³!", "foo", title);
    }

    @Test
    public void testSetTitle()
    {
	app.setTitle("foo");
	final String title = app.getTitle();
	assertEquals("Z³y tytu³!", "foo", title);
    }

    @Test
    public void testGetContent()
    {
	app.setContent("foo");
	final String content = app.getContent();
	assertEquals("B³êdny content","foo", content);
    }

    @Test
    public void testSetContent()
    {
	app.setContent("foo");
	final String content = app.getContent();
	assertEquals("B³êdny content","foo", content);
    }

    @Test
    public void testGetDispatchDate()
    {
	Date date = new Date();
	app.setDispatchDate(date);
	final Date datetested = app.getDispatchDate();
	assertEquals("B³êdna data",date, datetested);
    }

    @Test
    public void testSetDispatchDate()
    {
	Date date = new Date();
	app.setDispatchDate(date);
	final Date datetested = app.getDispatchDate();
	assertEquals("B³êdna data", date, datetested);
    }

    @Test
    public void testGetStatus()
    {
	app.setStatus("foo");
	final String status = app.getStatus();
	assertEquals("B³êdny status","foo", status);
    }

    @Test
    public void testSetStatus()
    {
	app.setStatus("foo");
	final String status = app.getStatus();
	assertEquals("B³êdny status","foo", status);
    }

    @Test
    public void testGetStudent()
    {
	StudentDTO uni = new StudentDTO();
	app.setStudent(uni);
	StudentDTO unitest = app.getStudent();
	assertEquals("B³êdny student",uni, unitest);
    }

    @Test
    public void testSetStudent()
    {
	StudentDTO uni = new StudentDTO();
	app.setStudent(uni);
	StudentDTO unitest = app.getStudent();
	assertEquals("B³êdny student",uni, unitest);
    }

    @Test
    public void testGetAdministrator()
    {
	AdministratorDTO uni = new AdministratorDTO();
	app.setAdministrator(uni);
	AdministratorDTO unitest = app.getAdministrator();
	assertEquals("B³êdny admin",uni, unitest);
    }

    @Test
    public void testSetAdministrator()
    {
	AdministratorDTO uni = new AdministratorDTO();
	app.setAdministrator(uni);
	AdministratorDTO unitest = app.getAdministrator();
	assertEquals("B³êdny admin",uni, unitest);
    }

}

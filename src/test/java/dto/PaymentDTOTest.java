package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.PaymentDTO;
import edziekanat.databasemodel.dto.StudentDTO;

public class PaymentDTOTest
{
    PaymentDTO pay;

    @Before
    public void setUp()
    {
	this.pay = new PaymentDTO();
    }

    @Test
    public void testGetId()
    {
	pay.setId(1);
	final int id = pay.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	pay.setId(1);
	final int id = pay.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetTitle()
    {
	pay.setTitle("foo");
	final String title = pay.getTitle();
	assertEquals("foo", title);
    }

    @Test
    public void testSetTitle()
    {
	pay.setTitle("foo");
	final String title = pay.getTitle();
	assertEquals("foo", title);
    }

    @Test
    public void testGetDescription()
    {
	pay.setDescription("foo");
	final String content = pay.getDescription();
	assertEquals("foo", content);
    }

    @Test
    public void testSetDescription()
    {
	pay.setDescription("foo");
	final String content = pay.getDescription();
	assertEquals("foo", content);
    }

    @Test
    public void testGetAmount()
    {
	pay.setAmount(1);
	final int id = Math.round(pay.getAmount());
	assertEquals(1, id);
    }

    @Test
    public void testSetAmount()
    {
	pay.setAmount(1);
	final int id = Math.round(pay.getAmount());
	assertEquals(1, id);
    }

    @Test
    public void testGetIssueDate()
    {
	Date date = new Date();
	pay.setIssueDate(date);
	final Date datetested = pay.getIssueDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetIssueDate()
    {
	Date date = new Date();
	pay.setIssueDate(date);
	final Date datetested = pay.getIssueDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetPaymentDate()
    {
	Date date = new Date();
	pay.setPaymentDate(date);
	final Date datetested = pay.getPaymentDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetPaymentDate()
    {
	Date date = new Date();
	pay.setPaymentDate(date);
	final Date datetested = pay.getPaymentDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetStudent()
    {
	StudentDTO uni = new StudentDTO();
	pay.setStudent(uni);
	StudentDTO unitest = pay.getStudent();
	assertEquals(uni, unitest);
    }

    @Test
    public void testSetStudent()
    {
	StudentDTO uni = new StudentDTO();
	pay.setStudent(uni);
	StudentDTO unitest = pay.getStudent();
	assertEquals(uni, unitest);
    }

    @Test
    public void testGetAdministrator()
    {
	AdministratorDTO uni = new AdministratorDTO();
	pay.setAdministrator(uni);
	AdministratorDTO unitest = pay.getAdministrator();
	assertEquals(uni, unitest);
    }

    @Test
    public void testSetAdministrator()
    {
	AdministratorDTO uni = new AdministratorDTO();
	pay.setAdministrator(uni);
	AdministratorDTO unitest = pay.getAdministrator();
	assertEquals(uni, unitest);
    }

}

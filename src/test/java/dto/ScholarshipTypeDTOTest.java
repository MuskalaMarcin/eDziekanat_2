package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.ScholarshipTypeDTO;

public class ScholarshipTypeDTOTest
{
    ScholarshipTypeDTO schType;

    @Before
    public void setUp() throws Exception
    {
	this.schType = new ScholarshipTypeDTO();
    }

    @Test
    public void testGetType()
    {
	schType.setType("typ");
	final String content = schType.getType();
	assertEquals("Niezgodny typ!", "typ", content);
    }

    @Test
    public void testSetType()
    {
	schType.setType("typ");
	final String content = schType.getType();
	assertEquals("Niezgodny typ!","typ", content);
    }

    @Test
    public void testGetRequirements()
    {
	schType.setRequirements("req");
	final String requ = schType.getRequirements();
	assertEquals("req", requ);
    }

    @Test
    public void testSetRequirements()
    {
	schType.setRequirements("req");
	final String requ = schType.getRequirements();
	assertEquals("req", requ);
    }

    @Test
    public void testGetAmount()
    {
	schType.setAmount(1F);
	final int id = Math.round(schType.getAmount());
	assertEquals(1, id);
    }

    @Test
    public void testSetAmount()
    {
	schType.setAmount(1F);
	final int id = Math.round(schType.getAmount());
	assertEquals(1, id);
    }

    @Test
    public void testGetScholarship()
    {
	List<ScholarshipDTO> scholar = new LinkedList<ScholarshipDTO>();
	schType.setScholarship(scholar);
	List<ScholarshipDTO> tested = schType.getScholarship();
	assertEquals(scholar, tested);
    }

    @Test
    public void testSetScholarship()
    {
	List<ScholarshipDTO> scholar = new LinkedList<ScholarshipDTO>();
	schType.setScholarship(scholar);
	List<ScholarshipDTO> tested = schType.getScholarship();
	assertEquals(scholar, tested);
    }

}

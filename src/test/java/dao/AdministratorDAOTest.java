package test.java.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;

public class AdministratorDAOTest
{
    @Test
    public void testGetEntity()
    {
	AdministratorDTO admin = new AdministratorDAO().getEntity(1);
	assertNotNull(admin);
    }

}

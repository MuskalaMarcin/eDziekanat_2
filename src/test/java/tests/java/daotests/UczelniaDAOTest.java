package tests.java.daotests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.edziekanat.databasemodel.dao.UczelniaDAO;
import com.edziekanat.databasemodel.dto.Uczelnia;

public class UczelniaDAOTest {

	@Test
	public void getSingleUczelniaTest() {
		UczelniaDAO uczelniaDao = new UczelniaDAO();
		Uczelnia uczelnia = uczelniaDao.getUczelnia("Politechnika Krakowska");
		assertEquals("Uczelnia id doesn't match correct value.", 1, uczelnia.getIdUczelni().intValue());
		assertEquals("Uczelnia name doesn't match expected value.", "Politechnika Krakowska", uczelnia.getNazwa());
		assertEquals("Adres of uczelnia doesn't match expected value.", "Krakow ul. Warszawska 24",
				uczelnia.getAdres());
	}
}

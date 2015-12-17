package com.edziekanat.databasemodel.dao;

import java.util.List;

import com.edziekanat.databasemodel.dto.Uczelnia;
import com.edziekanat.databasemodel.mappers.UczelniaMapper;

public class UczelniaDAO extends AbstractDAO {

	public Uczelnia getUczelnia(String nazwa) {
		String query = "Select * from uczelnia where nazwa = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { nazwa }, new UczelniaMapper());
	}

	public Uczelnia getUczelnia(String nazwa, String adres) {
		String query = "Select * from uczelnia where nazwa = ? and adres = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { nazwa, adres }, new UczelniaMapper());
	}

	public List<Uczelnia> getUczelniaList() {
		String query = "SELECT * from uczelnia";
		return jdbcTemplate.query(query, new UczelniaMapper());
	}
	
	public void update()
	{
		
	}
	
	public void delete()
	{
		
	}
}

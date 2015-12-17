package com.edziekanat.databasemodel.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.edziekanat.databasemodel.dto.Uczelnia;

public class UczelniaMapper implements RowMapper<Uczelnia> {

	@Override
	public Uczelnia mapRow(ResultSet arg0, int arg1) throws SQLException {
		Uczelnia uczelnia = new Uczelnia();
		uczelnia.setIdUczelni(arg0.getInt("idUczelni"));
		uczelnia.setNazwa(arg0.getString("nazwa"));
		uczelnia.setAdres(arg0.getString("adres"));
		return null;
	}

}

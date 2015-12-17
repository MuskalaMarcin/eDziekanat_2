package com.edziekanat.databasemodel.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AbstractDAO {

	@Autowired
	protected DataSource dataSource;

	protected JdbcTemplate jdbcTemplate;

	protected AbstractDAO() {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}

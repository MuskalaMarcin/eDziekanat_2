package edziekanat.databasemodel.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

public abstract class DAOParentClass
{
    @Resource(name="jdbc/edziekanat")
    protected DataSource databaseConnection;
}

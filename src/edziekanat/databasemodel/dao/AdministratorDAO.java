package edziekanat.databasemodel.dao;

import java.util.List;

import edziekanat.databasemodel.dto.AdministratorDTO;

public class AdministratorDAO extends DAOParentClass
{
    public AdministratorDTO getAdministrator(int id)
    {
	return entityManager.find(AdministratorDTO.class, id);
    }

    public List<AdministratorDTO> getMultipleAdministrators(String whereStmnt)
    {
	return executeMultiResultQuery("SELECT a FROM AdministratorDTO a WHERE a." + whereStmnt);
    }

    public List<AdministratorDTO> getAllAdministrators()
    {
	return executeMultiResultQuery("SELECT a FROM AdministratorDTO a");
    }
}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;

public interface IDAODepartamento {

	/**
	 * Metodo para listar los departamentos de un paise
	 * @param pais, pais por el cual se listaran los departamentos
	 * @return lista con los departamentos de ese pais
	 * @throws Exception
	 */
    public List<Departamento> listarDepartamentosPorPais(Pais pais) throws Exception;
	
}
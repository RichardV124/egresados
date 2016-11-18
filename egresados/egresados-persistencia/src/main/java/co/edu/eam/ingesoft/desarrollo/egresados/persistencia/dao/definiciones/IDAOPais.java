package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;

public interface IDAOPais {

	/**
	 * Metodo para listar los paises
	 * @return la lista de los paises
	 * @throws Exception
	 */
    public List<Pais> listarPais() throws Exception;
	
	
}

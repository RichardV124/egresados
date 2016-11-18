package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Ciudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;

public interface IDAOCiudad {

	/**
	 * Metodo para listar las ciudades de un paises
	 * @param depto, departamento por el cual se listaran las ciudades
	 * @return lista con las ciudades de ese departamento
	 * @throws Exception
	 */
    public List<Ciudad> listarCiudadPorDepartamento(Departamento depto) throws Exception;
	
	
}

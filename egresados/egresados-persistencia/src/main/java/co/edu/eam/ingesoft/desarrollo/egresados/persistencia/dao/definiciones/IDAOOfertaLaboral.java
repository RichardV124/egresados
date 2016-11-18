package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.OfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;

public interface IDAOOfertaLaboral {

	/**
	 * Metodo para listar las  ofertas laborales de un programa
	 * @param pro, programa 
	 * @return lista con los departamentos de ese pais
	 * @throws Exception
	 */
    public List<OfertaLaboral> listarOfertasPorPrograma(Programa pro) throws Exception;
}

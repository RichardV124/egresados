package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.SectorLaboral;

public interface IDAOSectorLaboral {

	/**
	 * Metodo para listar los sectores laborales
	 * @return la lista de los sectores laborales
	 * @throws Exception
	 */
    public List<SectorLaboral> listarSectoresLaborales() throws Exception;
	
	
}

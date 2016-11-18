package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOSectorLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOPaisJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOSectorLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.SectorLaboral;

/**
 * Objeto de negocio para todas las operaciones asociadas al SectorLaboral.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOSectorLaboral {

	/**
     * dao con los métodos de persistencia de sector laboral
     */
	private IDAOSectorLaboral daoSectorLaboral;
	
	/**
     * Coonstructor
     */
    public BOSectorLaboral() {
    	daoSectorLaboral = new DAOSectorLaboral();
    }
    
    /**
     * Método para listar los sectores laborales
     * @return una lista con los sectores laborales
     * @throws Exception 
     */
    /**
     * Objeto de negocio para todas las operaciones asociadas al Usuario.
     *
     * @author Richard Alexander Vanegas Ochoa<br/>
     *         email: Richardvanegas8@gmail.com <br/>
     *         Fecha: 23/10/2015<br/>
     */
    public List<SectorLaboral> listarSectoresLaborales() throws Exception{
        return daoSectorLaboral.listarSectoresLaborales();
    }
	
}

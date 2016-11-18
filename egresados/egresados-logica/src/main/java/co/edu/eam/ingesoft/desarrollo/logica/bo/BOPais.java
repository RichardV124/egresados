package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOPais;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOPaisJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;

/**
 * Objeto de negocio para todas las operaciones asociadas al Pais.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOPais {

	/**
     * dao con los métodos de persistencia de pais
     */
	private IDAOPais daoPais;
 
	/**
	 * Coonstructor
	 */
	public BOPais() {
		daoPais = new DAOPaisJPA();
	}
	
	    /**
	     * Método para listar los paises
	     * @return una lista con los paises
	     * @throws Exception 
	     */
	    public List<Pais> listarPais() throws Exception{
	        return daoPais.listarPais();
	    }
	    
}

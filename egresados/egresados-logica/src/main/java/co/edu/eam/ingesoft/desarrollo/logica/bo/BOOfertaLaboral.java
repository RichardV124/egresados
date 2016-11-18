package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOOfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOOfertaLaboralJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.OfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;


/**
 * Objeto de negocio para todas las operaciones asociadas al Pais.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOOfertaLaboral {

	private IDAOOfertaLaboral daoOferta;
	 
	/**
	 * Coonstructor
	 */
	public BOOfertaLaboral() {
		daoOferta = new DAOOfertaLaboralJPA();
	}
	
	/**
	 * Metodo para listar las ofertas laborales por programa
	 *@params programa, programa por el cual se listaran las ofertas
	 * @author Richard Alexander Vanegas Ochoa<br/>
	 *         email: Richardvanegas8@gmail.com <br/>
	 *         Fecha: 23/10/2015<br/>
	 */
    public List<OfertaLaboral> listarOfertas(Programa programa) throws Exception{
        return daoOferta.listarOfertasPorPrograma(programa);
    }
	
}

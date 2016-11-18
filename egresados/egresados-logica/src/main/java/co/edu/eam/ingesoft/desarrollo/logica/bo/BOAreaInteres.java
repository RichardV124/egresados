package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOAreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOAreaInteresJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;


/**
 * Objeto de negocio para todas las operaciones asociadas al AreaInteres.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOAreaInteres {


	/**
     * dao con los métodos de persistencia de area de interes
     */
	private IDAOAreaInteres daoAreaInteres;
	
	/**
     * Constructor
     */
	public BOAreaInteres(){
		daoAreaInteres= new DAOAreaInteresJPA();
	}
	
	 /**
     * Método con la lógica para crear un area de interes
     * @param area, el area de interes que se desea crear
     * @throws Exception
     */
    public void crear(AreaInteres area) throws Exception{
        if (daoAreaInteres.buscar(area.getCodigo()) != null) {
            throw new ExcepcionNegocio("Ya existe un area de interes con el codigo "
                    + area.getCodigo());
        } else {
        	daoAreaInteres.crear(area);
        }
    }
    
    /**
     * Método con la lógica para buscar un area de interes
     * @param codigo, el codigo del area de interes a buscar
     * @return el area de interes si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public AreaInteres buscar(String codigo) throws Exception{
        return daoAreaInteres.buscar(codigo);
    }
    
    /**
     * Método con la lógica para editar un area de interes
     * @param area, el area de interes que se desea editar
     * @throws Exception
     */
    public void editar(AreaInteres area) throws Exception{
        if (daoAreaInteres.buscar(area.getCodigo()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe un "
            		+ "area de interes con el codigo "+ area.getCodigo());
        } else {
        	daoAreaInteres.editar(area);
        }
    }
	
    /**
     * Método para listar las areas de interes
     * @return una lista con las areas de interes
     * @throws Exception 
     */
    public List<AreaInteres> listarAreasInteres() throws Exception{
        return daoAreaInteres.listarAreasInteres();
    }
}

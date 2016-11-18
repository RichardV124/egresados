package co.edu.eam.ingesoft.desarrollo.logica.bo;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOAreasEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOAreasEgresadoJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresadoPK;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;


/**
 * Objeto de negocio para todas las operaciones asociadas al AreaEgresado.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOAreasEgresado {

	/**
     * dao con los métodos de persistencia de areas de egresado
     */
	private IDAOAreasEgresado daoAreasEgresado;
	
	/**
     * Constructor
     */
	public BOAreasEgresado(){
		daoAreasEgresado= new DAOAreasEgresadoJPA();
	}
	
	 /**
     * Método con la lógica para crear un area de egresado
     * @param area, el area de egresadi que se desea crear
     * @throws Exception
     */
    public void crear(AreasEgresado area) throws Exception{
//        if (daoAreasEgresado.buscar(area.getEgresado().getCedula()) != null) {
//            throw new ExcepcionNegocio("Ya existe un area de interes para el egresado con documento "
//                    + area.getEgresado().getCedula());
//        } else {
        	daoAreasEgresado.crear(area);
       // }
    }
    
    /**
     * Método con la lógica para buscar un area de egresado
     * @param cedula, la cedula del egresado al que se le buscará el area
     * @return el area del egresado si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public AreasEgresado buscar(AreasEgresadoPK areasEgresadoPK) throws Exception{
        return daoAreasEgresado.buscar(areasEgresadoPK);
    }
    
    /**
     * Método con la lógica para editar un area del egresado
     * @param area, el area del egresado que se desea editar
     * @throws Exception
     */
    public void editar(AreasEgresado area) throws Exception{
    	AreasEgresadoPK arPK = new AreasEgresadoPK();
		arPK.setArea(area.getArea().getCodigo());
		arPK.setEgresado(area.getEgresado().getCedula());
        if (daoAreasEgresado.buscar(arPK) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe un "
            		+ "area de interes para el egresado con documento "+ area.getEgresado().getCedula());
        } else {
        	daoAreasEgresado.editar(area);
        }
    }
}

package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOFacultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOFacultadJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;


/**
 * Objeto de negocio para todas las operaciones asociadas a la facultad.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOFacultad {

	/**
     * dao con los métodos de persistencia de facultad
     */
	private IDAOFacultad daoFacultad;
	
	/**
     * Constructor
     */
	public BOFacultad(){
		daoFacultad= new DAOFacultadJPA();
	}
	
	 /**
     * Método con la lógica para crear una facultad
     * @param facultad, la facultad que se desea crear
     * @throws Exception
     */
    public void crear(Facultad facultad) throws Exception{
        if (daoFacultad.buscar(facultad.getCodigo()) != null) {
            throw new ExcepcionNegocio("Ya existe una facultad con el codigo "
                    + facultad.getCodigo());
        } else {
        	daoFacultad.crear(facultad);
        }
    }
    
    /**
     * Método con la lógica para buscar una facultad
     * @param codigo, el codigo de la facultad a buscar
     * @return la facultad si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public Facultad buscar(String codigo) throws Exception{
        return daoFacultad.buscar(codigo);
    }
    
    /**
     * Método con la lógica para editar una facultad
     * @param facultad, la facultad que se desea editar
     * @throws Exception
     */
    public void editar(Facultad facultad) throws Exception{
        if (daoFacultad.buscar(facultad.getCodigo()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe una "
            		+ "facultad con el codigo "+ facultad.getCodigo());
        } else {
        	daoFacultad.editar(facultad);
        }
    }
    
    /**
     * Método para listar las facultades
     * @return una lista con las facultades
     * @throws Exception 
     */
    public List<Facultad> listarFacultad() throws Exception{
        return daoFacultad.listarFacultad();
    }
}

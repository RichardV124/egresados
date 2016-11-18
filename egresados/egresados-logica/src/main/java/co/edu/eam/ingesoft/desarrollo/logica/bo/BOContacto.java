package co.edu.eam.ingesoft.desarrollo.logica.bo;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOContacto;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOContactoJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Contacto;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

/**
 * Objeto de negocio para todas las operaciones asociadas al Contacto.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOContacto {

	/**
     * dao con los métodos de persistencia de contacto
     */
	private IDAOContacto daoContacto;
	
	/**
     * Constructor
     */
	public BOContacto(){
		daoContacto= new DAOContactoJPA();
	}
	
	 /**
     * Método con la lógica para crear un contacto de empresa
     * @param  contacto, el contacto que se desea crear
     * @throws Exception
     */
    public void crear(Contacto contacto) throws Exception{
        if (daoContacto.buscar(contacto.getNitEmpresa()) != null) {
            throw new ExcepcionNegocio("Ya existe un contacto con el nit de empresa "
                    + contacto.getNitEmpresa());
        } else {
        	daoContacto.crear(contacto);
        }
    }
    
    /**
     * Método con la lógica para buscar un contacto
     * @param nit, el nit de la empresa a la cual pertenece el contacto a buscar
     * @return el contacto si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public Contacto buscar(String nit) throws Exception{
        return daoContacto.buscar(nit);
    }
    
    /**
     * Método con la lógica para editar un contacto
     * @param contacto, el contacto que se desea editar
     * @throws Exception
     */
    public void editar(Contacto contacto) throws Exception{
        if (daoContacto.buscar(contacto.getNitEmpresa()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe un "
            		+ "contacto con el nit de empresa "+ contacto.getNitEmpresa());
        } else {
        	daoContacto.editar(contacto);
        }
    }
	
}

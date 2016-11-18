package co.edu.eam.ingesoft.desarrollo.logica.bo;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOInformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOInformacionAcademicaJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

/**
 * Objeto de negocio para todas las operaciones asociadas a la InformacionAcademica.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOInformacionAcademica {

	/**
     * dao con los métodos de persistencia de informacion academica
     */
	private IDAOInformacionAcademica daoInfoAcademica;
	
	
	public BOInformacionAcademica() {
		daoInfoAcademica = new DAOInformacionAcademicaJPA();
	}
	
	/**
     * Método con la lógica para crear una informacion academica
     * @param  informacionAcademica, la informacionAcademica que se desea crear
     * 
     * @throws Exception
     */
    public void crear(InformacionAcademica informacionAcademica) throws Exception{
//        if (daoInfoAcademica.buscar(informacionAcademica.getCedEgresado()) != null) {
//            throw new ExcepcionNegocio("Ya existe una informacion academica con la cédula "
//                    + informacionAcademica.getCedEgresado());
//        } else {
        	daoInfoAcademica.crear(informacionAcademica);
//        }
    }
    
    /**
     * Método con la lógica para buscar una informacion academica
     * @param ced, la cedula del egresado al que se le quiere buscar la informacion academica
     * @return el egresado si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public InformacionAcademica buscar(String ced) throws Exception{
        return daoInfoAcademica.buscar(ced);
    }
    
    /**
     * Método con la lógica para editar una informacion academica
     * @param informacionAcademica, la informacionAcademica que se desea editar
     * @throws Exception
     */
    public void editar(InformacionAcademica informacionAcademica) throws Exception{
        if (daoInfoAcademica.buscar(informacionAcademica.getCedEgresado()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe una "
            		+ "informacion academica con la cédula "+ informacionAcademica.getCedEgresado());
        } else {
        	daoInfoAcademica.editar(informacionAcademica);
        }
    }
}

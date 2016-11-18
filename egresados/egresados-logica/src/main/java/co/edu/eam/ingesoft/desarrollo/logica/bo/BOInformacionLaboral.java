package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOInformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOInformacionLaboralJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

/**
 * Objeto de negocio para todas las operaciones asociadas a la InformacionLaboral.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOInformacionLaboral {

	/**
     * dao con los m�todos de persistencia de informacion laboral
     */
	private IDAOInformacionLaboral daoInfoLaboral;
	
	
	public BOInformacionLaboral() {
		daoInfoLaboral = new DAOInformacionLaboralJPA();
	}
	
	/**
     * M�todo con la l�gica para crear una informacion Laboral
     * @param  informacionLaboral, la informacionLaboral que se desea crear
     * 
     * @throws Exception
     */
    public void crear(InformacionLaboral informacionLaboral) throws Exception{
//        if (daoInfoLaboral.buscar(informacionLaboral.getCedEgresado()) != null) {
//            throw new ExcepcionNegocio("Ya existe una informacion Laboral con la c�dula "
//                    + informacionLaboral.getCedEgresado());
//        } else {
        	daoInfoLaboral.crear(informacionLaboral);
//        }
    }
    
    /**
     * M�todo con la l�gica para buscar una informacion Laboral
     * @param ced, la cedula del egresado al que se le quiere buscar la informacion Laboral
     * @return el egresado si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public InformacionLaboral buscar(String ced) throws Exception{
        return daoInfoLaboral.buscar(ced);
    }
    
    /**
     * M�todo con la l�gica para editar una informacion Laboral
     * @param informacionLaboral, la informacionLaboral que se desea editar
     * @throws Exception
     */
    public void editar(InformacionLaboral informacionLaboral) throws Exception{
        if (daoInfoLaboral.buscar(informacionLaboral.getCedEgresado()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe una "
            		+ "informacion academica con la c�dula "+ informacionLaboral.getCedEgresado());
        } else {
        	daoInfoLaboral.editar(informacionLaboral);
        }
    }
    
    /**
     * M�todo para listar las informaciones laborales
     * @return la lista de las informaciones laborales
     * @throws Exception 
     */
    public List<InformacionLaboral> listarInformacionLaboral() throws Exception{
        return daoInfoLaboral.listarInformacionLaboral();
    }
    
    /**
     * M�todo para listar las informaciones laborales
     * @return la lista de las informaciones laborales
     * @throws Exception 
     */
    public List<InformacionLaboral> listarInformacionLaboralPorPrograma(Programa p) throws Exception{
        return daoInfoLaboral.listarInformacionLaboralPorPrograma(p);
    }
}

package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOEgresadoJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;


/**
 * Objeto de negocio para todas las operaciones asociadas al Egresado.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOEgresado {

	/**
     * dao con los métodos de persistencia de egresado
     */
	private IDAOEgresado daoEgresado;
	
	/**
     * Constructor
     */
	public BOEgresado() {
		daoEgresado = new DAOEgresadoJPA();
	}
	
	/**
     * Método con la lógica para crear un egresado
     * @param  empresa, la empresa que se desea crear
     * 
     * @throws Exception
     */
    public void crear(Egresado egresado) throws Exception{
        if (daoEgresado.buscar(egresado.getCedula()) != null) {
            throw new ExcepcionNegocio("Ya existe un egresado con la cédula "
                    + egresado.getCedula());
        } else {
        	daoEgresado.crear(egresado);
        }
    }
    
    /**
     * Método con la lógica para buscar un egresado
     * @param ced, el ced del egresado que se quiere buscar
     * @return el egresado si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public Egresado buscar(String ced) throws Exception{
        return daoEgresado.buscar(ced);
    }
    
    /**
     * Método con la lógica para editar un egresado
     * @param egresado, el egresado que se desea editar
     * @throws Exception
     */
    public void editar(Egresado egresado) throws Exception{
        if (daoEgresado.buscar(egresado.getCedula()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe un "
            		+ "egresado con la cédula "+ egresado.getCedula());
        } else {
        	daoEgresado.editar(egresado);
        }
    }
    
    /**
     * Método para listar los egresados de una empresa
     * @param emp, empresa a la cual se le buscaran los egresados
     * @return la lista de los egresados 
     * @throws Exception 
     */
    public List<Egresado> listarEgresadosPorEmpresa(Empresa emp) throws Exception{
        return daoEgresado.listarEgresadosPorEmpresa(emp);
    }
	
}

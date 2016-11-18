package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOEmpresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOEmpresaJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;


/**
 * Objeto de negocio para todas las operaciones asociadas a la Empresa.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOEmpresa {

	/**
     * dao con los métodos de persistencia de empresa
     */
	private IDAOEmpresa daoEmpresa;
	
	/**
     * Constructor
     */
	public BOEmpresa(){
		daoEmpresa= new DAOEmpresaJPA();
	}
	
	 /**
     * Método con la lógica para crear una empresa
     * @param  empresa, la empresa que se desea crear
     * @throws Exception
     */
    public void crear(Empresa empresa) throws Exception{
        if (daoEmpresa.buscar(empresa.getNit()) != null) {
            throw new ExcepcionNegocio("Ya existe una empresa con el nit "
                    + empresa.getNit());
        } else {
        	daoEmpresa.crear(empresa);
        }
    }
    
    /**
     * Método con la lógica para buscar una empresa
     * @param nit, el nit de la empresa que se quiere buscar
     * @return la empresa si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public Empresa buscar(String nit) throws Exception{
        return daoEmpresa.buscar(nit);
    }
    
    /**
     * Método con la lógica para editar una empresa
     * @param empresa, la empresa que se desea editar
     * @throws Exception
     */
    public void editar(Empresa empresa) throws Exception{
        if (daoEmpresa.buscar(empresa.getNit()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe una "
            		+ "empresa con el nit "+ empresa.getNit());
        } else {
        	daoEmpresa.editar(empresa);
        }
    }
    
    /**
     * Método para listar las empresas
     * @return una lista con las empresas
     * @throws Exception 
     */
    public List<Empresa> listar() throws Exception{
        return daoEmpresa.listar();
    }
	
}

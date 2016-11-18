package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;

public interface IDAOEmpresa {

	/**
	 * Metodo para crear una empresa en la Base de datos
	 * 
	 * @param empresa, empresa que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(Empresa empresa) throws Exception;
	

	/**
	 * Metodo para editar una empresa de la Base de datos
	 * @param empresa, empresa a editar
	 */
	public void editar(Empresa empresa)throws Exception;
	
	
	/**
	 * Metodo que busca una empresa por el codigo
	 * @param nit, nit de la empresa a buscar  
	 * @return La empresa si esta, en caso contrario null
	 */
	public Empresa buscar(String nit) throws Exception;
	
	/**
	 * Metodo para listar las empresas
	 * @return la lista de las empresas
	 * @throws Exception
	 */
    public List<Empresa> listar() throws Exception;
	
}

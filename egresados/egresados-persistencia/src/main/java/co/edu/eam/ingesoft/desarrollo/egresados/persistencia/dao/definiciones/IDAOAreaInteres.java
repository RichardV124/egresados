package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;

public interface IDAOAreaInteres {

	/**
	 * Metodo para crear una area de interes en la Base de datos
	 * 
	 * @param area, area de interes que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(AreaInteres area) throws Exception;
	

	/**
	 * Metodo para editar una area de interes de la Base de datos
	 * @param area, area a editar
	 */
	public void editar(AreaInteres area)throws Exception;
	
	
	/**
	 * Metodo que busca una area de interes por el codigo
	 * @param codigo, codigo de la facultad a buscar  
	 * @return El area de interes si esta, en caso contrario null
	 */
	public AreaInteres buscar(String codigo) throws Exception;
	
	/**
	 * Metodo para listar las areas de interes
	 * @return la lista de las areas de interes
	 * @throws Exception
	 */
    public List<AreaInteres> listarAreasInteres() throws Exception;
}

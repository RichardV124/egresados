package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Contacto;

public interface IDAOContacto {

	/**
	 * Metodo para crear un contacto en la Base de datos
	 * 
	 * @param contacto, contacto que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(Contacto contacto) throws Exception;
	

	/**
	 * Metodo para editar un contacto de la Base de datos
	 * @param contacto, contacto a editar
	 */
	public void editar(Contacto contacto)throws Exception;
	
	
	/**
	 * Metodo que busca un contacto por el codigo
	 * @param nit, nit de la empresa a la cual pertenece el contacto a buscar  
	 * @return El contacto si esta, en caso contrario null
	 */
	public Contacto buscar(String nit) throws Exception;
	
}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionAcademica;

public interface IDAOInformacionAcademica {

	/**
	 * Metodo para crear una informacion academica en la Base de datos
	 * 
	 * @param informacionAcademica, informacionAcademica que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(InformacionAcademica informacionAcademica) throws Exception;
	

	/**
	 * Metodo para editar una informacionAcademica de la Base de datos
	 * @param informacionAcademica, informacionAcademica a editar
	 */
	public void editar(InformacionAcademica informacionAcademica)throws Exception;
	
	
	/**
	 * Metodo que busca una informacionAcademica por la cedula del egresado
	 * @param ced, ced del egresado al que se le buscara la informacion academica  
	 * @return La informacionAcademica si está, en caso contrario null
	 */
	public InformacionAcademica buscar(String ced) throws Exception;
}

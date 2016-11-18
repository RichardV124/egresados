package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;


import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;

public interface IDAOFacultad {

	/**
	 * Metodo para crear una facultad en la Base de datos
	 * 
	 * @param facultad, facultad que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(Facultad facultad) throws Exception;
	

	/**
	 * Metodo para editar una facultad de la Base de datos
	 * @param facultad, facultad a editar
	 */
	public void editar(Facultad facultad)throws Exception;
	
	
	/**
	 * Metodo que busca una facultad por el codigo
	 * @param codigo, codigo de la facultad a buscar  
	 * @return La facultad si esta, en caso contrario null
	 */
	public Facultad buscar(String codigo) throws Exception;
	
	/**
	 * Metodo para listar las facultades
	 * @return la lista de las facultades
	 * @throws Exception
	 */
    public List<Facultad> listarFacultad() throws Exception;
}

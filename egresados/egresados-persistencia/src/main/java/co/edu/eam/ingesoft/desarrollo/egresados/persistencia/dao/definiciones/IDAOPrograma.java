package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;

public interface IDAOPrograma {

	/**
	 * Metodo para crear un programa en la Base de datos
	 * 
	 * @param programa, programa que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(Programa programa) throws Exception;
	

	/**
	 * Metodo para editar una programa de la Base de datos
	 * @param programa, programa a editar
	 */
	public void editar(Programa programa)throws Exception;
	
	
	/**
	 * Metodo que busca un programa por el codigo
	 * @param codigo, codigo del programa a buscar  
	 * @return El programa si esta, en caso contrario null
	 */
	public Programa buscar(String codigo) throws Exception;
	
	/**
	 * Metodo para listar los programas
	 * @return la lista de los programas
	 * @throws Exception
	 */
    public List<Programa> listarPrograma(String facultad) throws Exception;
    
    /**
	 * Metodo para listar los programas
	 * @return la lista de los programas
	 * @throws Exception
	 */
    public List<Programa> listarProgramas() throws Exception;
	
}

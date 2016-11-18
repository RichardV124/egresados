package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresadoPK;

public interface IDAOAreasEgresado {

	/**
	 * Metodo para crear un area de egresado en la Base de datos
	 * 
	 * @param area, area de egresado que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(AreasEgresado area) throws Exception;
	

	/**
	 * Metodo para editar un area de egresado de la Base de datos
	 * @param area, area a editar
	 */
	public void editar(AreasEgresado area)throws Exception;
	
	
	/**
	 * Metodo que busca un area de egresado por el codigo del area y el codigo del egresado
	 * @param codEgresado, codigo del egresado a buscar
	 * @return El area de egresado si esta, en caso contrario null
	 */
	public AreasEgresado buscar(AreasEgresadoPK areaEgresadoPk) throws Exception;
}

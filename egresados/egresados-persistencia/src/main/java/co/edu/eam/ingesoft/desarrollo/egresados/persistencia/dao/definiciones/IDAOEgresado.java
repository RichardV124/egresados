package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Ciudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;

public interface IDAOEgresado {

	/**
	 * Metodo para crear un egresado en la Base de datos
	 * 
	 * @param egresado, egresado que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(Egresado egresado) throws Exception;
	

	/**
	 * Metodo para editar un egresado de la Base de datos
	 * @param empresa, empresa a editar
	 */
	public void editar(Egresado egresado)throws Exception;
	
	
	/**
	 * Metodo que busca un egresado por la cedula
	 * @param ced, ced del egresado a buscar  
	 * @return La empresa si esta, en caso contrario null
	 */
	public Egresado buscar(String ced) throws Exception;
	
	/**
	 * Metodo para listar los egresados por empresa
	 * @param emp, eempresa por la cual se listaran los egresados
	 * @return lista con las ciudades de ese departamento
	 * @throws Exception
	 */
    public List<Egresado> listarEgresadosPorEmpresa(Empresa emp) throws Exception;
}

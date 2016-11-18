package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;

public interface IDAOInformacionLaboral {

	/**
	 * Metodo para crear una informacion laboral en la Base de datos
	 * 
	 * @param informacionLaboral, informacionLaboral que se va a crear           
	 * @throws Excepcion
	 */
	public void crear(InformacionLaboral informacionLaboral) throws Exception;
	

	/**
	 * Metodo para editar una informacionLaboral de la Base de datos
	 * @param informacionLaboral, informacionLaboral a editar
	 */
	public void editar(InformacionLaboral informacionLaboral)throws Exception;
	
	
	/**
	 * Metodo que busca una informacionLaboral por la cedula del egresado
	 * @param ced, ced del egresado al que se le buscara la informacion laboral  
	 * @return La informacionLaboral si está, en caso contrario null
	 */
	public InformacionLaboral buscar(String ced) throws Exception;
	
	/**
	 * Metodo para listar informacion laboral
	 * @return lista con las informaciones laborales
	 * @throws Exception
	 */
    public List<InformacionLaboral> listarInformacionLaboral() throws Exception;
    
    /**
	 * Metodo para listar informacion laboral
	 * @return lista con las informaciones laborales
	 * @throws Exception
	 */
    public List<InformacionLaboral> listarInformacionLaboralPorPrograma(Programa p) throws Exception;
}

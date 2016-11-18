package co.edu.eam.ingesoft.egresados.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEgresado;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEmpresa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOInformacionLaboral;

public class ControladorEmpleadosEmpresa {

	/**
	 * bo que contiene la lógica de empresa
	 */
	private BOEmpresa boEmpresa;
	
	/**
	 * bo que contiene la lógica de egresado
	 */
	private BOEgresado boEgresado;
	
	/**
	 * bo que contiene la lógica de informacion laboral
	 */
	private BOInformacionLaboral boInformacionLaboral;
	
	/**
     * Constructor
     */
	public ControladorEmpleadosEmpresa() {
		boEmpresa = new BOEmpresa();
		boEgresado = new BOEgresado();
		boInformacionLaboral = new BOInformacionLaboral();
	}
	
	/**
	 * Método para listar las empresas
	 * 
	 * @return la lista de las empresas
	 * @throws Exception
	 */
	public List<Empresa> listarEmpresa() throws Exception {
		return boEmpresa.listar();
	}
	
	/**
	 * Método para listar los egresados de una empresa
	 * 
	 * @return la lista de los egresados
	 * @throws Exception
	 */
	public List<Egresado> listarEgresadosPorEmpresa(Empresa emp) throws Exception {
		return boEgresado.listarEgresadosPorEmpresa(emp);
	}
	
	/**
	 * Método para listar las informaciones laborales
	 * @return la lista de las informaciones laborales
	 * @throws Exception
	 */
	public List<InformacionLaboral> listarInformacionLaboral() throws Exception {
		return boInformacionLaboral.listarInformacionLaboral();
	}
}

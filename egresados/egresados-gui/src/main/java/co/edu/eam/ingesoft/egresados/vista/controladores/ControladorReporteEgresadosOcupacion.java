package co.edu.eam.ingesoft.egresados.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEgresado;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEmpresa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOInformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPrograma;

public class ControladorReporteEgresadosOcupacion {

	/**
	 * bo que contiene la lógica de informacion laboral
	 */
	private BOInformacionLaboral boInformacionLaboral;
	
	/**
	 * bo que contiene la lógica de programa
	 */
	private BOPrograma boPrograma;
	
	/**
     * Constructor
     */
	public ControladorReporteEgresadosOcupacion() {
		boInformacionLaboral = new BOInformacionLaboral();
		boPrograma = new BOPrograma();
	}
	
	
	/**
	 * Método para listar las informaciones laborales
	 * @return la lista de las informaciones laborales
	 * @throws Exception
	 */
	public List<InformacionLaboral> listarInformacionLaboral() throws Exception {
		return boInformacionLaboral.listarInformacionLaboral();
	}
	
	/**
	 * Método para listar las informaciones laborales
	 * @return la lista de las informaciones laborales
	 * @throws Exception
	 */
	public List<InformacionLaboral> listarInformacionLaboralPorPrograma(Programa p) throws Exception {
		return boInformacionLaboral.listarInformacionLaboralPorPrograma(p);
	}
	
	/**
	 * Método para listar todos los programas
	 * @return la lista de los programas
	 * @throws Exception
	 */
	public List<Programa> listarProgamas() throws Exception {
		return boPrograma.listarProgramas();
	}
}

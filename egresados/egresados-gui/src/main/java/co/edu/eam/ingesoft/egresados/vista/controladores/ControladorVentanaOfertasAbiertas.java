package co.edu.eam.ingesoft.egresados.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.OfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAreaInteres;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOOfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPrograma;

public class ControladorVentanaOfertasAbiertas {

	/**
	 * bo que contiene la logica de ofertalaboral
	 */
	private BOOfertaLaboral boOferta;
	
	/**
	 * bo que contiene la logica de programa
	 */
	private BOPrograma boPrograma;
	
	/**
	 * bo que contiene la logica de area interes
	 */
	private BOAreaInteres boArea;
	
	/**
	 * Controlador ofertas abiertas
	 */
	public ControladorVentanaOfertasAbiertas(){
		boOferta = new BOOfertaLaboral();
		boPrograma = new BOPrograma();
		boArea = new BOAreaInteres();
	}

	/**
	 * Método para listar las ofertas laborales
	 * 
	 * @return la lista de las ofertas laborales
	 * @throws Exception
	 */
	public List<OfertaLaboral> listarOfertas(Programa programa) throws Exception {
		return boOferta.listarOfertas(programa);

	}

	/**
	 * Método para listar todos los programas
	 * 
	 * @return la lista de los programas
	 * @throws Exception
	 */
	public List<Programa> listarProgramas() throws Exception {
		return boPrograma.listarProgramas();
	}
	
	/**
	 * Método para listar todas las areas de interes
	 * 
	 * @return la lista de las areas de interes
	 * @throws Exception
	 */
	public List<AreaInteres> listarArea() throws Exception{
		return boArea.listarAreasInteres();
	}

}

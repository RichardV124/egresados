package co.edu.eam.ingesoft.egresados.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.OfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOOfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPrograma;

public class ControladorOfertasPrograma {

	/**
	 * bo que contiene la logica de ofertalaboral
	 */
	private BOOfertaLaboral boOferta;
	
	/**
	 * bo que contiene la logica de programa
	 */
	private BOPrograma boPrograma;
	
	/**
	 * Controlador ofertas programa
	 */
	public ControladorOfertasPrograma(){
		boOferta = new BOOfertaLaboral();
		boPrograma = new BOPrograma();
	}
	
	
	/**
	 * M�todo para listar las ofertas laborales
	 * 
	 * @return la lista de las ofertas laborales
	 * @throws Exception
	 */
	public List<OfertaLaboral> listarOfertas(Programa programa) throws Exception {
		return boOferta.listarOfertas(programa);
	}
	
	/**
	 * M�todo para listar todos los programas
	 * 
	 * @return la lista de los programas
	 * @throws Exception
	 */
	public List<Programa> listarProgramas() throws Exception{
		return boPrograma.listarProgramas();
	}
	 
}

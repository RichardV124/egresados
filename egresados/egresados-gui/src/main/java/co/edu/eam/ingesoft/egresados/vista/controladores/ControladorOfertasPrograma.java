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
	 * bo que contiene la logica de ofertalaboral
	 */
	private BOPrograma boPrograma;
	
	public ControladorOfertasPrograma(){
		boOferta = new BOOfertaLaboral();
		boPrograma = new BOPrograma();
	}
	
	
	/**
	 * Método para listar las ofertas laborales
	 * 
	 * @return la lista de las empresas
	 * @throws Exception
	 */
	public List<OfertaLaboral> listarOfertas(Programa programa) throws Exception {
		return boOferta.listarOfertas(programa);
	}
	
	public List<Programa> listarProgramas() throws Exception{
		return boPrograma.listarProgramas();
	}
	 
}

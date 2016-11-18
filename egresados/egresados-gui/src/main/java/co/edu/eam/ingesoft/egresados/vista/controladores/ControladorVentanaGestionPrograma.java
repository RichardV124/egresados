package co.edu.eam.ingesoft.egresados.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOFacultad;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPrograma;

public class ControladorVentanaGestionPrograma {


	 /**
    * bo que contiene la l�gica de programa
    */
   private BOPrograma boPrograma;
   
   /**
    * bo que contiene la l�gica de facultad
    */
   private BOFacultad boFacultad;
	
   /**
    * Constructor del ControladorVentanaGestionPrograma
    */
   public ControladorVentanaGestionPrograma(){
	   boPrograma = new BOPrograma();
	   boFacultad = new BOFacultad();
   }
   
   /**
    * M�todo para crear un programa
    * @param programa que se va a crear
    * @throws Exception
    */
   public void crearPrograma(Programa programa) throws Exception{
	   boPrograma.crear(programa);
   }
   
   /**
    * M�todo para buscar un programa
    * @param codigo, el c�digo con el que se va a buscar el programa
    * @return el programa si lo encuentra, de lo contrario null
    * @throws Exception
    */
   public Programa buscarPrograma(String codigo) throws Exception{
       return boPrograma.buscar(codigo);
   }
   
   /**
    * M�todo para editar un programa
    * @param programa, el programa que sera editado
    * @throws Exception 
    */
   public void editarPrograma(Programa programa) throws Exception{
	   boPrograma.editar(programa);
   }
	
   /**
	 * M�todo para listar las facultades
	 * 
	 * @return la lista de las facultades
	 * @throws Exception
	 */
	public List<Facultad> listarFacultad() throws Exception {
		return boFacultad.listarFacultad();
	}
   
	/**
     * M�todo para buscar una facultad
     * @param codigo, el c�digo con el que se va a buscar la facultad
     * @return la facultad si la encuentra, de lo contrario null
     * @throws Exception
     */
    public Facultad buscarFacultad(String codigo) throws Exception{
        return boFacultad.buscar(codigo);
    }
}

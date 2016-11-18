package co.edu.eam.ingesoft.egresados.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOFacultad;

public class ControladorVentanaGestionFacultad {

	 /**
     * bo que contiene la lógica de facultad
     */
    private BOFacultad boFacultad;
	
    /**
     * Constructor del ControladorVentanaGestionFacultad
     */
    public ControladorVentanaGestionFacultad(){
    	boFacultad = new BOFacultad();
    }
    
    /**
     * Método para crear una facultad
     * @param facultad que se va a crear
     * @throws Exception
     */
    public void crearFacultad(Facultad facultad) throws Exception{
    	boFacultad.crear(facultad);
    }
    
    /**
     * Método para buscar una facultad
     * @param codigo, el código con el que se va a buscar la facultad
     * @return la facultad si la encuentra, de lo contrario null
     * @throws Exception
     */
    public Facultad buscarFacultad(String codigo) throws Exception{
        return boFacultad.buscar(codigo);
    }
    
    /**
     * Método para editar una facultad
     * @param facultad, la facultad que sera editada
     * @throws Exception 
     */
    public void editarFacultad(Facultad facultad) throws Exception{
        boFacultad.editar(facultad);
    }
    
}

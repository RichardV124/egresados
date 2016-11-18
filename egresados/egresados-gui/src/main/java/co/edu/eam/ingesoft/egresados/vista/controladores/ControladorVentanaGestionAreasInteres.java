package co.edu.eam.ingesoft.egresados.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAreaInteres;

public class ControladorVentanaGestionAreasInteres {

	 /**
     * bo que contiene la l�gica de area de interes
     */
    private BOAreaInteres boAreasInteres;
	
    /**
     * Constructor del ControladorVentanaGestionAreasInteres
     */
    public ControladorVentanaGestionAreasInteres(){
    	boAreasInteres = new BOAreaInteres();
    }
    
    /**
     * M�todo para crear un area de interes
     * @param area, area de interes que se va a crear
     * @throws Exception
     */
    public void crearArea(AreaInteres area) throws Exception{
    	boAreasInteres.crear(area);
    }
    
    /**
     * M�todo para buscar un area de interes
     * @param codigo, el c�digo con el que se va a buscar el area de interes
     * @return el area de interes si la encuentra, de lo contrario null
     * @throws Exception
     */
    public AreaInteres buscarArea(String codigo) throws Exception{
        return boAreasInteres.buscar(codigo);
    }
    
    /**
     * M�todo para editar un area de interes
     * @param area, el area de interes que se va a editar
     * @throws Exception 
     */
    public void editarArea(AreaInteres area) throws Exception{
    	boAreasInteres.editar(area);
    }
	
}

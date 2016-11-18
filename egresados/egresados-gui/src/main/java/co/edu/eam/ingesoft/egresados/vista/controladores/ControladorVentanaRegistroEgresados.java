package co.edu.eam.ingesoft.egresados.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.SectorLaboral;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAreaInteres;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAreasEgresado;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEgresado;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOFacultad;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOInformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOInformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPrograma;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOSectorLaboral;

public class ControladorVentanaRegistroEgresados {

	/**
	 * bo con la lógica de sector laboral
	 */
	private BOSectorLaboral boSectorLaboral;

	/**
	 * bo que contiene la lógica de facultad
	 */
	private BOFacultad boFacultad;

	/**
	 * bo que contiene la lógica de programa
	 */
	private BOPrograma boPrograma;

	/**
	 * bo que contiene la lógica de egresado
	 */
	private BOEgresado boEgresado;
	
	/**
	 * bo que contiene la lógica de informacion academica
	 */
	private BOInformacionAcademica boInformacionAcademica;
	
	/**
	 * bo que contiene la lógica de informacion laboral
	 */
	private BOInformacionLaboral boInformacionLaboral;
	
	/**
	 * bo que contiene la lógica de area de interes
	 */
	private BOAreaInteres boAreaInteres;
	
	/**
	 * bo que contiene la lógica de areas de egresado
	 */
	private BOAreasEgresado boAreasEgresado;
	
	/**
	 * Constructor
	 */
	public ControladorVentanaRegistroEgresados() {
		boSectorLaboral = new BOSectorLaboral();
		boPrograma = new BOPrograma();
		boFacultad = new BOFacultad();
		boEgresado = new BOEgresado();
		boInformacionAcademica = new BOInformacionAcademica();
		boInformacionLaboral = new BOInformacionLaboral();
		boAreaInteres = new BOAreaInteres();
		boAreasEgresado = new BOAreasEgresado();
	}

	/**
	 * Método para listar los sectores laborales
	 * 
	 * @return la lista de los sectores laborales
	 * @throws Exception
	 */
	public List<SectorLaboral> listarSectoresLaborales() throws Exception {
		return boSectorLaboral.listarSectoresLaborales();
	}

	/**
	 * Método para listar las areas de interes
	 * 
	 * @return la lista de las areas de interes
	 * @throws Exception
	 */
	public List<AreaInteres> listarAreasInteres() throws Exception {
		return boAreaInteres.listarAreasInteres();
	}
	
	/**
	 * Método para listar las facultades
	 * 
	 * @return la lista de las facultades
	 * @throws Exception
	 */
	public List<Facultad> listarFacultad() throws Exception {
		return boFacultad.listarFacultad();
	}
	
	/**
	 * Método para listar los programas
	 * 
	 * @return la lista de los programas
	 * @throws Exception
	 */
	public List<Programa> listarPrograma(String facultad) throws Exception {
		return boPrograma.listarPrograma(facultad);
	}
	
	/**
	    * Método para crear un egresado
	    * @param egresado, egresado que se va a crear
	    * @throws Exception
	    */
	   public void crearEgresado(Egresado egresado) throws Exception{
		   boEgresado.crear(egresado);
	   }
	   
	 /**
	    * Método para crear un area de egresado
	    * @param area, area de egresado que se va a crear
	    * @throws Exception
	    */
	   public void crearAreaEgresado(AreasEgresado area) throws Exception{
		   boAreasEgresado.crear(area);
	   }
	   
	   /**
	    * Método para buscar un egresado
	    * @param ced, la cedula con la que se va a buscar el egresado
	    * @return el egresado si lo encuentra, de lo contrario null
	    * @throws Exception
	    */
	   public Egresado buscarEgresado(String ced) throws Exception{
	       return boEgresado.buscar(ced);
	   }
	   
	   /**
	    * Método para editar un egresado
	    * @param egresado, el egresado que sera editada
	    * @throws Exception 
	    */
	   public void editarEgresado(Egresado egresado) throws Exception{
		   boEgresado.editar(egresado);
	   }

	   
	   /**
	    * Método para crear una InformacionAcademica
	    * @param informacionAcademica, InformacionAcademica que se va a crear
	    * @throws Exception
	    */
	   public void crearInformacionAcademica(InformacionAcademica informacionAcademica) throws Exception{
		   boInformacionAcademica.crear(informacionAcademica);
	   }
	   
	   /**
	    * Método para buscar una InformacionAcademica
	    * @param ced, la cedula con la que se va a buscar la informacion academica del egresado
	    * @return la informacionAcademica si la encuentra, de lo contrario null
	    * @throws Exception
	    */
	   public InformacionAcademica buscarInformacionAcademica(String ced) throws Exception{
	       return boInformacionAcademica.buscar(ced);
	   }
	   
	   /**
	    * Método para editar una InformacionAcademica
	    * @param informacionAcademica, la InformacionAcademica que sera editada
	    * @throws Exception 
	    */
	   public void editarInformacionAcademica(InformacionAcademica informacionAcademica) throws Exception{
		   boInformacionAcademica.editar(informacionAcademica);
	   }
	   
	   /**
	    * Método para editar un area de egresado
	    * @param areaegresado, el areaegresado que seva editada
	    * @throws Exception 
	    */
	   public void editarAreaEgresado(AreasEgresado areaegresado) throws Exception{
		   boAreasEgresado.editar(areaegresado);
	   }
	   
	   
	   /**
	    * Método para crear una InformacionLaboral
	    * @param informacionLaboral, InformacionLaboral que se va a crear
	    * @throws Exception
	    */
	   public void crearInformacionLaboral(InformacionLaboral informacionLaboral) throws Exception{
		   boInformacionLaboral.crear(informacionLaboral);;
	   }
	   
	   /**
	    * Método para buscar una InformacionLaboral
	    * @param ced, la cedula con la que se va a buscar la informacion laboral del egresado
	    * @return la informacionLaboral si la encuentra, de lo contrario null
	    * @throws Exception
	    */
	   public InformacionLaboral buscarInformacionLaboral(String ced) throws Exception{
	       return boInformacionLaboral.buscar(ced);
	   }
	   
	   /**
	    * Método para editar una InformacionLaboral
	    * @param informacionAcademica, la InformacionAcademica que sera editada
	    * @throws Exception 
	    */
	   public void editarInformacionLaboral(InformacionLaboral informacionLaboral) throws Exception{
		   boInformacionLaboral.editar(informacionLaboral);
	   }
}

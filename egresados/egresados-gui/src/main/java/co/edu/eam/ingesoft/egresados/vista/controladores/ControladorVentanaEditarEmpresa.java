package co.edu.eam.ingesoft.egresados.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Ciudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Contacto;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.SectorLaboral;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOCiudad;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOContacto;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BODepartamento;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEmpresa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPais;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOSectorLaboral;

public class ControladorVentanaEditarEmpresa {


	/**
	 * bo con la l�gica de pais
	 */
	private BOPais boPais;
	
	/**
	 * bo con la l�gica de departamento
	 */
	private BODepartamento boDepartamento;

	/**
	 * bo con la l�gica de ciudad
	 */
	private BOCiudad boCiudad;
	
	/**
	 * bo con la l�gica de sector laboral
	 */
	private BOSectorLaboral boSectorLaboral;
	
	/**
	 * bo que contiene la l�gica de contacto
	 */
	private BOContacto boContacto;
	
	/**
	 * bo que contiene la l�gica de empresa
	 */
	private BOEmpresa boEmpresa;
	
	/**
	 * Constructor
	 */
	public ControladorVentanaEditarEmpresa() {
		// TODO Auto-generated constructor stub
		boPais = new BOPais();
		boDepartamento = new BODepartamento();
		boCiudad = new BOCiudad();
		boSectorLaboral = new BOSectorLaboral();
		boContacto = new BOContacto();
		boEmpresa = new BOEmpresa();
	}

	/**
	 * M�todo para listar los paises
	 * 
	 * @return la lista de los paises
	 * @throws Exception
	 */
	public List<Pais> listarPais() throws Exception {
		return boPais.listarPais();
	}

	/**
	 * M�todo para listar los departamentos de un pais
	 * 
	 * @param pais,el pais del cual pertenecen los departamentos
	 * @return la lista de los departamentos del pais
	 * @throws Exception
	 */
	public List<Departamento> listarDepartamentosPorPais(Pais pais) throws Exception {
		return boDepartamento.listarDepartamentosPorPais(pais);
	}
	
	/**
	 * M�todo para listar las ciudades de un departamento
	 * 
	 * @param depto,el departamento del cual pertenecen las ciudades
	 * @return la lista de las ciudades del departamento
	 * @throws Exception
	 */
	public List<Ciudad> listarCiudadPorDepartamento(Departamento depto) throws Exception {
		return boCiudad.listarCiudadPorDepartamento(depto);
	}

	/**
	 * M�todo para listar los sectores laborales
	 * 
	 * @return la lista de los sectores laborales
	 * @throws Exception
	 */
	public List<SectorLaboral> listarSectoresLaborales() throws Exception {
		return boSectorLaboral.listarSectoresLaborales();
	}

	/**
	    * M�todo para crear un contacto
	    * @param contacto que se va a crear
	    * @throws Exception
	    */
	   public void crearContacto(Contacto contacto) throws Exception{
		   boContacto.crear(contacto);
	   }
	   
	   /**
	    * M�todo para buscar un programa
	    * @param nit, el nit con el que se va a buscar el contacto
	    * @return el contacto si lo encuentra, de lo contrario null
	    * @throws Exception
	    */
	   public Contacto buscarContacto(String nit) throws Exception{
	       return boContacto.buscar(nit);
	   }
	   
	   /**
	    * M�todo para editar un contacto
	    * @param contacto, el contacto que sera editado
	    * @throws Exception 
	    */
	   public void editarContacto(Contacto contacto) throws Exception{
		   boContacto.editar(contacto);
	   }
		
		/**
	    * M�todo para crear una empresa
	    * @param empresa, empresa que se va a crear
	    * @throws Exception
	    */
	   public void crearEmpresa(Empresa empresa) throws Exception{
		   boEmpresa.crear(empresa);
	   }
	   
	   /**
	    * M�todo para buscar un empresa
	    * @param nit, el nit con el que se va a buscar la empresa
	    * @return la empresa si la encuentra, de lo contrario null
	    * @throws Exception
	    */
	   public Empresa buscarEmpresa(String nit) throws Exception{
	       return boEmpresa.buscar(nit);
	   }
	   
	   /**
	    * M�todo para editar una empresa
	    * @param empresa, la empresa que sera editada
	    * @throws Exception 
	    */
	   public void editarEmpresa(Empresa empresa) throws Exception{
		   boEmpresa.editar(empresa);
	   }
	
}

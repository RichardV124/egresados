package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOPrograma;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOProgramaJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

/**
 * Objeto de negocio para todas las operaciones asociadas al Programa.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOPrograma {

	/**
     * dao con los métodos de persistencia de programa
     */
	private IDAOPrograma daoPrograma;
	
	/**
     * Constructor
     */
	public BOPrograma(){
		daoPrograma= new DAOProgramaJPA();
	}
	
	 /**
     * Método con la lógica para crear un programa
     * @param programa, el programa que se desea crear
     * @throws Exception
     */
    public void crear(Programa programa) throws Exception{
        if (daoPrograma.buscar(programa.getCodigo()) != null) {
            throw new ExcepcionNegocio("Ya existe un programa con el codigo "
                    + programa.getCodigo());
        } else {
        	daoPrograma.crear(programa);
        }
    }
    
    /**
     * Método con la lógica para buscar un programa
     * @param codigo, el codigo del programa a buscar
     * @return el programa si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public Programa buscar(String codigo) throws Exception{
        return daoPrograma.buscar(codigo);
    }
    
    /**
     * Método con la lógica para editar un programa
     * @param programa, el programa que se desea editar
     * @throws Exception
     */
    public void editar(Programa programa) throws Exception{
        if (daoPrograma.buscar(programa.getCodigo()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe un "
            		+ "programa con el codigo "+ programa.getCodigo());
        } else {
        	daoPrograma.editar(programa);
        }
    }
    
    /**
     * Método para listar los programas
     * @return una lista con los programas
     * @throws Exception 
     */
    public List<Programa> listarPrograma(String facultad) throws Exception{
        return daoPrograma.listarPrograma(facultad);
    }
    
    /**
     * Método para listar los programas
     * @return una lista con los programas
     * @throws Exception 
     */
    public List<Programa> listarProgramas() throws Exception{
        return daoPrograma.listarProgramas();
    }
}
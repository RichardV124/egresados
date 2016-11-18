package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOCiudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAOCiudadJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Ciudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;

/**
 * Objeto de negocio para todas las operaciones asociadas a la ciudad.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BOCiudad {

private IDAOCiudad daoCiudad;
	
	public BOCiudad(){
		daoCiudad = new DAOCiudadJPA();
	}
	
	/**
	 * Metodo para listar las ciudades de un paises
	 * @param depto, departamento por el cual se listaran las ciudades
	 * @return lista con las ciudades de ese departamento
	 * @throws Exception
	 */
    public List<Ciudad> listarCiudadPorDepartamento(Departamento depto) throws Exception{
        return daoCiudad.listarCiudadPorDepartamento(depto);
    }
	
}

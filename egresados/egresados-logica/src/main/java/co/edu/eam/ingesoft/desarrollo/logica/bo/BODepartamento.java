package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAODepartamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa.DAODepartamentoJPA;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;

/**
 * Objeto de negocio para todas las operaciones asociadas al Departamento.
 *
 * @author Richard Alexander Vanegas Ochoa<br/>
 *         email: Richardvanegas8@gmail.com <br/>
 *         Fecha: 23/10/2015<br/>
 */
public class BODepartamento {

	/**
     * dao con los métodos de persistencia de departamento
     */
	private IDAODepartamento daoDepartamento;
	
	public BODepartamento(){
		daoDepartamento = new DAODepartamentoJPA();
	}
	
	/**
     * Método para listar los departamentos de un pais
     * @param pais, el pais del cual pertenecen los departamentos
     * @return la lista de los departamentos del pais
     * @throws Exception 
     */
    public List<Departamento> listarDepartamentosPorPais(Pais pais) throws Exception{
        return daoDepartamento.listarDepartamentosPorPais(pais);
    }
}

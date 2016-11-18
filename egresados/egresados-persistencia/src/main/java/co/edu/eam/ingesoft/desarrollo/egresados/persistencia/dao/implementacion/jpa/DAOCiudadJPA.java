package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOCiudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Ciudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOCiudadJPA implements IDAOCiudad{

	public List<Ciudad> listarCiudadPorDepartamento(Departamento depto) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
        Query query = em.createNamedQuery(Ciudad.LISTAR_CIUDADES_POR_DEPARTAMENTO);
        query.setParameter(1, depto);
        return query.getResultList();
	}

}

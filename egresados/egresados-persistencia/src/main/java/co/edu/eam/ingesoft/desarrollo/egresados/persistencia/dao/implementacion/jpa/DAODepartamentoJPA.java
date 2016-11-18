package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAODepartamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Pais;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAODepartamentoJPA implements IDAODepartamento{

	/**
     * Método con la lógica para listar los departamentos por su pais
     * @param pais, pais por el cual se listaran los departamentos
     * @throws Exception
     */
	public List<Departamento> listarDepartamentosPorPais(Pais pais) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
        Query query = em.createNamedQuery(Departamento.LISTAR_DEPARTAMENTOS_POR_PAIS);
        query.setParameter(1, pais);
        return query.getResultList();
	}

}

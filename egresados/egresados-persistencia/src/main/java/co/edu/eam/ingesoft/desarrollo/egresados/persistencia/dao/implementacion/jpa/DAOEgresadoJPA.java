package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Departamento;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOEgresadoJPA implements IDAOEgresado{

	public void crear(Egresado egresado) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Egresado e = buscar(egresado.getCedula());
		if (e == null) {
			em.getTransaction().begin();

			em.persist(egresado);

			em.getTransaction().commit();
		}
	}
	
	public void editar(Egresado egresado) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(egresado);

		em.getTransaction().commit();
	}

	public Egresado buscar(String ced) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Egresado.class, ced);
	}


	public List<Egresado> listarEgresadosPorEmpresa(Empresa emp) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
        Query query = em.createNamedQuery(Egresado.LISTAR_EGRESADOS_POR_EMPRESA);
        query.setParameter(1, emp);
        return query.getResultList();
	}

}

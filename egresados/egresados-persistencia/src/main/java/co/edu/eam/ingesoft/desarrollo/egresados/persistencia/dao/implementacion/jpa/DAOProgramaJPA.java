package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOPrograma;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOProgramaJPA implements IDAOPrograma{

	public void crear(Programa programa) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Programa p = buscar(programa.getCodigo());
		if (p == null) {
			em.getTransaction().begin();

			em.persist(programa);

			em.getTransaction().commit();
		}
	}

	public void editar(Programa programa) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(programa);

		em.getTransaction().commit();
	}

	public Programa buscar(String codigo) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Programa.class, codigo);
	}

	public List<Programa> listarPrograma(String programa) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Programa.CONSULTA_LISTAR_PROGRAMAS_POR_FACULTAD);
		query.setParameter(1, programa);
		return query.getResultList();
	}
	
	public List<Programa> listarProgramas() throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Programa.CONSULTA_LISTAR_PROGRAMAS);
		return query.getResultList();
	}

}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOInformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOInformacionLaboralJPA implements IDAOInformacionLaboral{

	public void crear(InformacionLaboral informacionLaboral) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		InformacionLaboral e = buscar(informacionLaboral.getCedEgresado());
		if (e == null) {
			em.getTransaction().begin();

			em.persist(informacionLaboral);

			em.getTransaction().commit();
		}
	}

	public void editar(InformacionLaboral informacionLaboral) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(informacionLaboral);

		em.getTransaction().commit();
	}

	public InformacionLaboral buscar(String ced) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(InformacionLaboral.class, ced);
	}

	public List<InformacionLaboral> listarInformacionLaboral() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
        Query query = em.createNamedQuery(InformacionLaboral.LISTAR_INFORMACION_LABORAL);
        return query.getResultList();
	}
	
	public List<InformacionLaboral> listarInformacionLaboralPorPrograma(Programa p) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
        Query query = em.createNamedQuery(InformacionLaboral.LISTAR_INFORMACION_LABORAL);
        query.setParameter(1, p);
        return query.getResultList();
	}

}

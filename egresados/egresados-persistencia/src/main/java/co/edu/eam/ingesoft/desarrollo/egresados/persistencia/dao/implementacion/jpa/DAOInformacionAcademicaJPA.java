package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOInformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOInformacionAcademicaJPA implements IDAOInformacionAcademica{

	public void crear(InformacionAcademica informacionAcademica) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		InformacionAcademica e = buscar(informacionAcademica.getCedEgresado());
		if (e == null) {
			em.getTransaction().begin();

			em.persist(informacionAcademica);

			em.getTransaction().commit();
		}
	}

	public void editar(InformacionAcademica informacionAcademica) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(informacionAcademica);

		em.getTransaction().commit();
	}

	public InformacionAcademica buscar(String ced) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(InformacionAcademica.class, ced);
	}

}

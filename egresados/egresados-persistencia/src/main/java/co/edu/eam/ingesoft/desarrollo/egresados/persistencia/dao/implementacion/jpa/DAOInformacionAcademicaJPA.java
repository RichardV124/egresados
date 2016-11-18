package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOInformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOInformacionAcademicaJPA implements IDAOInformacionAcademica{

	/**
     * Método con la lógica para crear una informacion academica
     * @param informacionAcademica, la informacionAcademica que se desea crear
     * @throws Exception
     */
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

	/**
     * Método con la lógica para editar una informacion academica
     * @param informacionAcademica, la informacionAcademica que se desea editar
     * @throws Exception
     */
	public void editar(InformacionAcademica informacionAcademica) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(informacionAcademica);

		em.getTransaction().commit();
	}

	/**
     * Método con la lógica para buscar una informacion academica
     * @param ced, cedula del egresado que posee la informacion academica
     * @throws Exception
     */
	public InformacionAcademica buscar(String ced) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(InformacionAcademica.class, ced);
	}

}

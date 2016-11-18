package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOContacto;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Contacto;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOContactoJPA implements IDAOContacto{

	/**
     * Método con la lógica para crear un contacto
     * @param contacto, el contacto que se desea crear
     * @throws Exception
     */
	public void crear(Contacto contacto) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Contacto c = buscar(contacto.getNitEmpresa());
		if (c == null) {
			em.getTransaction().begin();

			em.persist(contacto);

			em.getTransaction().commit();
		}
	}

	/**
     * Método con la lógica para editar un contacto
     * @param contacto, el contacto que se desea crear
     * @throws Exception
     */
	public void editar(Contacto contacto) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(contacto);

		em.getTransaction().commit();
	}

	/**
     * Método con la lógica para buscar un contacto
     * @param nitEmpresa, el nit de la empresa
     * @throws Exception
     */
	public Contacto buscar(String nitEmpresa) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Contacto.class, nitEmpresa);
	}
	
}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOFacultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOFacultadJPA implements IDAOFacultad{

	/**
     * Método con la lógica para crear una facultad
     * @param facultad, la facultad que se desea crear
     * @throws Exception
     */
	public void crear(Facultad facultad) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Facultad f = buscar(facultad.getCodigo());
		if (f == null) {
			em.getTransaction().begin();

			em.persist(facultad);

			em.getTransaction().commit();
		}
	}

	/**
     * Método con la lógica para editar una facultad
     * @param facultad, la facultad que se desea editar
     * @throws Exception
     */
	public void editar(Facultad facultad) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(facultad);

		em.getTransaction().commit();
	}

	/**
     * Método con la lógica para buscar una facultad
     * @param codigo, codigo de la facultad que se desea buscar
     * @throws Exception
     */
	public Facultad buscar(String codigo) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Facultad.class, codigo);
	}

	/**
     * Método con la lógica para listar todas las facultades registradas
     * @throws Exception
     */
	public List<Facultad> listarFacultad() throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Facultad.CONSULTA_LISTAR_FACULTADES);
		return query.getResultList();
	}

}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOAreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOAreaInteresJPA implements IDAOAreaInteres{

	/**
     * Método con la lógica para crear un area de interes
     * @param area, el area de interes que se desea crear
     * @throws Exception
     */
	public void crear(AreaInteres area) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		AreaInteres a = buscar(area.getCodigo());
		if (a == null) {
			em.getTransaction().begin();

			em.persist(area);

			em.getTransaction().commit();
		}
	}

	/**
     * Método con la lógica para editar un area de interes
     * @param area, el area de interes que se desea editar
     * @throws Exception
     */
	public void editar(AreaInteres area) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(area);

		em.getTransaction().commit();
	}

	
	/**
     * Método con la lógica para buscar un area de interes
     * @param codigo, el codigo del area de interes a buscar
     * @return el area de interes si la encuentra, de lo contrario null
     * @throws Exception 
     */
	public AreaInteres buscar(String codigo) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(AreaInteres.class, codigo);
	}

	/**
     * Método con la lógica para listar las areas de interes
     * @return una lista con las areas de interes registradas
     * @throws Exception 
     */
	public List<AreaInteres> listarAreasInteres() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(AreaInteres.CONSULTA_LISTAR_AREASINTERES);
		return query.getResultList();
	}

}

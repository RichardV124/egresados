package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOPrograma;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOProgramaJPA implements IDAOPrograma{

	/**
     * Método con la lógica para crear un programa
     * @param programa, el programa que se desea crear
     * @throws Exception
     */
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

	/**
     * Método con la lógica para editar un programa
     * @param programa, el programa que se desea editar
     * @throws Exception
     */
	public void editar(Programa programa) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(programa);

		em.getTransaction().commit();
	}

	/**
     * Método con la lógica para buscar un programa
     * @param codigo, codigo del programa que se desea buscar
     * @throws Exception
     */
	public Programa buscar(String codigo) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Programa.class, codigo);
	}

	/**
     * Método con la lógica para listar los programas
     * @param programa, nombre del programa que se desea buscar
     * @throws Exception
     */
	public List<Programa> listarPrograma(String programa) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Programa.CONSULTA_LISTAR_PROGRAMAS_POR_FACULTAD);
		query.setParameter(1, programa);
		return query.getResultList();
	}
	
	/**
     * Método con la lógica para listar todos los programas registrados
     * @throws Exception
     */
	public List<Programa> listarProgramas() throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Programa.CONSULTA_LISTAR_PROGRAMAS);
		return query.getResultList();
	}

}

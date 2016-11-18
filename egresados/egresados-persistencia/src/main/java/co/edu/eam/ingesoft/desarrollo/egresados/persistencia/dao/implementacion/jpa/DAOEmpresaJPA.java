package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOEmpresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;
import java.util.List;

public class DAOEmpresaJPA implements IDAOEmpresa{

	/**
     * Método con la lógica para crear una empresa
     * @param empresa, la empresa que se desea crear
     * @throws Exception
     */
	public void crear(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Empresa e = buscar(empresa.getNit());
		if (e == null) {
			em.getTransaction().begin();

			em.persist(empresa);

			em.getTransaction().commit();
		}
	}

	/**
     * Método con la lógica para editar una empresa
     * @param empresa, la empresa que se desea crear
     * @throws Exception
     */
	public void editar(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(empresa);

		em.getTransaction().commit();
	}

	/**
     * Método con la lógica para buscar una empresa
     * @param nit, el nit de la empresa que se desea buscar
     * @throws Exception
     */
	public Empresa buscar(String nit) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Empresa.class, nit);
	}

	/**
     * Método con la lógica para listar las empresas
     * @throws Exception
     */
	public List<Empresa> listar() throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Empresa.CONSULTA_LISTAR_EMPRESAS);
		return query.getResultList();
	}
	
	
}

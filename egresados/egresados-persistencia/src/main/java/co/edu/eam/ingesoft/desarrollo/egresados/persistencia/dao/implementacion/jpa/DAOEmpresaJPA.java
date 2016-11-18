package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOEmpresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;
import java.util.List;

public class DAOEmpresaJPA implements IDAOEmpresa{

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

	public void editar(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(empresa);

		em.getTransaction().commit();
	}

	public Empresa buscar(String nit) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Empresa.class, nit);
	}

	public List<Empresa> listar() throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Empresa.CONSULTA_LISTAR_EMPRESAS);
		return query.getResultList();
	}
	
	
}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOOfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.OfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOOfertaLaboralJPA implements IDAOOfertaLaboral{

	public List<OfertaLaboral> listarOfertasPorPrograma(Programa p) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(OfertaLaboral.CONSULTA_LISTAR_OFERTAS_PROGRAMA);
		query.setParameter(1, p);
		return query.getResultList();
	}

	
}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.dao.definiciones.IDAOAreasEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresadoPK;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.utilidades.AdministradorEntityManager;

public class DAOAreasEgresadoJPA implements IDAOAreasEgresado{

	/**
     * Método con la lógica para crear un area de egresado
     * @param area, el area de egresadi que se desea crear
     * @throws Exception
     */
	public void crear(AreasEgresado area) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		AreasEgresadoPK arPK = new AreasEgresadoPK();
		arPK.setArea(area.getArea().getCodigo());
		arPK.setEgresado(area.getEgresado().getCedula());
		AreasEgresado a = buscar(arPK);
		if (a == null) {
			em.getTransaction().begin();

			em.persist(area);

			em.getTransaction().commit();
		}
	}

	/**
     * Método con la lógica para editar un area de egresado
     * @param area, el area de egresado que se desea editar
     * @throws Exception
     */
	public void editar(AreasEgresado area) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(area);

		em.getTransaction().commit();
	}

	/**
     * Método con la lógica para buscar un area de egresado
     * @param area, el area de egresadi que se desea crear
     * @throws Exception
     */
	public AreasEgresado buscar(AreasEgresadoPK areaEgresadoPk) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(AreasEgresado.class, areaEgresadoPk);
	}

}

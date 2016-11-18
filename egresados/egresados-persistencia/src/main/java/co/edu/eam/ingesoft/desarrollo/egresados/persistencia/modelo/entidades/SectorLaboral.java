package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="T_SECTORLABORAL")
@NamedQueries({
    @NamedQuery(name = SectorLaboral.CONSULTA_LISTAR_SECTORES_LABORALES, query = "SELECT sl FROM SectorLaboral sl")
})
public class SectorLaboral implements Serializable{

	public static final String CONSULTA_LISTAR_SECTORES_LABORALES = "Pais.listarSectoresLaborales";
	
	@Id
	@Column(name="ID_SECTOR",nullable=false)
	private int id;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;

	public SectorLaboral() {
		super();
	}

	public SectorLaboral(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return nombre;
	}
	
	
	
}

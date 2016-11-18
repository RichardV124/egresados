package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="T_CIUDAD")
@NamedQueries(
        {@NamedQuery(name = Ciudad.LISTAR_CIUDADES_POR_DEPARTAMENTO, query = "SELECT ci FROM Ciudad  ci"
        		+ " WHERE ci.departamento=?1")
        })
public class Ciudad implements Serializable{
	
	public static final String LISTAR_CIUDADES_POR_DEPARTAMENTO="Ciudad.listarCiudadesPorDepartamento";
	@Id
	@Column(name="ID_CIUDAD",nullable=false)
	private int id;
	
	@JoinColumn(name="ID_DEPARTAMENTO",nullable=false)
	@ManyToOne
	private Departamento departamento;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;

	public Ciudad() {
		super();
	}

	public Ciudad(int id, Departamento departamento, String nombre) {
		super();
		this.id = id;
		this.departamento = departamento;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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

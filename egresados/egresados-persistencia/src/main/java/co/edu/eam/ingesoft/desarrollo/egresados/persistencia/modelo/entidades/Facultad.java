package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="T_FACULTAD")
@NamedQueries({
    @NamedQuery(name = Facultad.CONSULTA_LISTAR_FACULTADES, query = "SELECT f FROM Facultad f")
})
public class Facultad implements Serializable {
	
	public static final String CONSULTA_LISTAR_FACULTADES = "Facultad.listarFacultades";
	
	@Id
	@Column(name="COD_FACULTAD",nullable=false)
	private String codigo;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;

	@Column(name="DESCRIPCION",nullable=false)
	private String descripcion;
	
	public Facultad() {
		super();
	}

	public Facultad(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString(){
		return codigo + " - " + nombre;
	}
		
}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="T_AREAINTERES")
@NamedQueries({
    @NamedQuery(name = AreaInteres.CONSULTA_LISTAR_AREASINTERES, query = "SELECT ai FROM AreaInteres ai")
})
public class AreaInteres implements Serializable{

	public static final String CONSULTA_LISTAR_AREASINTERES = "AreaInteres.listarAreasInteres";
	
	@Id
	@Column(name="COD_AREA",nullable=false)
	private String codigo;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION",nullable=false)
	private String descripcion;

	public AreaInteres() {
		super();
	}

	public AreaInteres(String codigo, String nombre, String descripcion) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaInteres other = (AreaInteres) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}

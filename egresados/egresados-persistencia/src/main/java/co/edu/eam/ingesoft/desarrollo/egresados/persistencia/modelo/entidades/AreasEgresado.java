package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(AreasEgresadoPK.class)
@Table(name="T_AREAS_EGRESADO")
public class AreasEgresado implements Serializable{

	@Id
	@JoinColumn(name="CED_EGRESADO",nullable=false)
	@ManyToOne
	private Egresado egresado;
	
	@Id
	@JoinColumn(name="COD_AREA",nullable=false)
	@ManyToOne
	private AreaInteres area;

	public AreasEgresado() {
		super();
	}

	/**
	 * @param egresado
	 * @param area
	 */
	public AreasEgresado(Egresado egresado, AreaInteres area) {
		super();
		this.egresado = egresado;
		this.area = area;
	}

	/**
	 * @return the egresado
	 */
	public Egresado getEgresado() {
		return egresado;
	}

	/**
	 * @param egresado the egresado to set
	 */
	public void setEgresado(Egresado egresado) {
		this.egresado = egresado;
	}

	/**
	 * @return the area
	 */
	public AreaInteres getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(AreaInteres area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((egresado == null) ? 0 : egresado.hashCode());
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
		AreasEgresado other = (AreasEgresado) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (egresado == null) {
			if (other.egresado != null)
				return false;
		} else if (!egresado.equals(other.egresado))
			return false;
		return true;
	}

	

	
	
	
	
}

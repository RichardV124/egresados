package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

public class AreasEgresadoPK implements Serializable{

	private String egresado;
	
	private String area;

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
		AreasEgresadoPK other = (AreasEgresadoPK) obj;
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

	public AreasEgresadoPK() {
		super();
	}

	public String getEgresado() {
		return egresado;
	}

	public void setEgresado(String egresado) {
		this.egresado = egresado;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(HistorialLaboralPK.class)
@Table(name="T_HIST_LABORAL")
public class HistorialLaboral implements Serializable{

	@Id
	@JoinColumn(name="CED_EGRESADO",nullable=false)
	@ManyToOne
	private InformacionLaboral egresado;
	
	@Id
	@JoinColumn(name="NIT_EMPRESA",nullable=false)
	@ManyToOne
	private Empresa empresa;

	
	public HistorialLaboral() {
		super();
	}

	public HistorialLaboral(InformacionLaboral egresado, Empresa empresa) {
		super();
		this.egresado = egresado;
		this.empresa = empresa;
	}

	public InformacionLaboral getEgresado() {
		return egresado;
	}

	public void setEgresado(InformacionLaboral egresado) {
		this.egresado = egresado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}

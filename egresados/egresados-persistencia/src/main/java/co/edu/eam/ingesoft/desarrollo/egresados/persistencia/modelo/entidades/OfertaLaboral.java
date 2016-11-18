package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_OFERTALABORAL")
public class OfertaLaboral implements Serializable {

	@Id
	@Column(name = "ID_OFERTA", nullable = false)
	private int id;

	@JoinColumn(name = "NIT_EMPRESA", nullable = false)
	@ManyToOne
	private Empresa empresa;

	@JoinColumn(name = "ID_CIUDAD", nullable = false)
	@ManyToOne
	private Ciudad ciudad;

	@JoinColumn(name = "ID_AREA", nullable = false)
	@ManyToOne
	private AreaInteres areaInteres;

	@Column(name = "CARGO", nullable = false)
	private String cargo;

	@Column(name = "SALARIO")
	private double salario;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "REQUERIMIENTOS")
	private String requerimientos;
	
	@Column(name="FECHA_APERTURA")
	@Temporal(TemporalType.DATE)
	private Date fechaApertura;
	
	@JoinColumn(name="PROGRAMA",nullable=false)
	@ManyToOne
	private Programa programa;

	public OfertaLaboral() {
		super();
	}

}

package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_OFERTALABORAL")
@NamedQueries({
    @NamedQuery(name = OfertaLaboral.CONSULTA_LISTAR_OFERTAS_PROGRAMA, query = "SELECT ol FROM OfertaLaboral ol WHERE ol.programa=?1")
})
public class OfertaLaboral implements Serializable {

	public static final String CONSULTA_LISTAR_OFERTAS_PROGRAMA = "OfertaLaboral.listarOfertas";
	
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
	
	@Column(name="FECHA_CIERRE")
	@Temporal(TemporalType.DATE)
	private Date fechaCierre;
	
	@JoinColumn(name="PROGRAMA",nullable=false)
	@ManyToOne
	private Programa programa;

	@Column(name="CERRAR_OFERTA")
	private boolean cerrarOferta;
	
	public OfertaLaboral() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public AreaInteres getAreaInteres() {
		return areaInteres;
	}

	public void setAreaInteres(AreaInteres areaInteres) {
		this.areaInteres = areaInteres;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRequerimientos() {
		return requerimientos;
	}

	public void setRequerimientos(String requerimientos) {
		this.requerimientos = requerimientos;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public boolean isCerrarOferta() {
		return cerrarOferta;
	}

	public void setCerrarOferta(boolean cerrarOferta) {
		this.cerrarOferta = cerrarOferta;
	}

	
	
}

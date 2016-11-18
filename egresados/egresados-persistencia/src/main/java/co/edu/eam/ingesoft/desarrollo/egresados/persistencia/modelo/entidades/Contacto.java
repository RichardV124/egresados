package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CONTACTO")
public class Contacto implements Serializable{

	@Id
	@Column(name="NIT_EMPRESA")
	private String nitEmpresa;
	
	@OneToOne
	@JoinColumn(name="NIT_EMPRESA",insertable=false,updatable=false)
	@MapsId
	private Empresa empresa;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombreCompleto;
	
	@Column(name="CORREO",nullable=false)
	private String correo;
	
	@Column(name="CARGO_EMPRESA")
	private String cargoEmpresa;
	
	@Column(name="TELEFONO",nullable=false)
	private String telefono;

	public Contacto() {
		super();
	}

	public Contacto(String nitEmpresa, String nombreCompleto, String correo, String cargoEmpresa,
			String telefono) {
		super();
		this.nitEmpresa = nitEmpresa;
		this.nombreCompleto = nombreCompleto;
		this.correo = correo;
		this.cargoEmpresa = cargoEmpresa;
		this.telefono = telefono;
	}

	public String getNitEmpresa() {
		return nitEmpresa;
	}

	public void setNitEmpresa(String nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCargoEmpresa() {
		return cargoEmpresa;
	}

	public void setCargoEmpresa(String cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}

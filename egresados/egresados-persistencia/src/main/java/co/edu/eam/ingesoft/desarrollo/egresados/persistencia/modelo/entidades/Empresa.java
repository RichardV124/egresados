package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoEmpresaEnum;

@Entity
@Table(name="T_EMPRESA")
@NamedQueries({
    @NamedQuery(name = Empresa.CONSULTA_LISTAR_EMPRESAS, query = "SELECT e FROM Empresa e")
})
public class Empresa implements Serializable{
	
	public static final String CONSULTA_LISTAR_EMPRESAS = "Empresa.listarEmpresas";
	
	@Id
	@Column(name="NIT_EMPRESA",nullable=false)
	private String nit;
	
	@JoinColumn(name="ID_SECTOR",nullable=false)
	@ManyToOne
	private SectorLaboral sector;
	
	@JoinColumn(name="ID_CIUDAD",nullable=false)
	@ManyToOne
	private Ciudad ciudad;
	
	@OneToOne(mappedBy="empresa")
	private Contacto contacto;
	
	@Column(name="RAZON_SOCIAL",nullable=false)
	private String razonSocial;
	
	@Column(name="TELEFONO",nullable=false)
	private String tel;
	
	@Column(name="TIPO_EMPRESA",nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoEmpresaEnum tipoEmpresa; //(privada, publica)
	
	@Column(name="FAX",nullable=false)
	private String fax;
	
	@Column(name="SITIO_WEB",nullable=false)
	private String sitioWeb;
	
	@Column(name="DIRECCION",nullable=false)
	private String direccion;
	
	public Empresa() {
		super();
	}

	public Empresa(String nit, SectorLaboral sector, Ciudad ciudad, Contacto contacto, String razonSocial, String tel,
			TipoEmpresaEnum tipoEmpresa, String fax, String sitioWeb, String direccion) {
		super();
		this.nit = nit;
		this.sector = sector;
		this.ciudad = ciudad;
		this.contacto = contacto;
		this.razonSocial = razonSocial;
		this.tel = tel;
		this.tipoEmpresa = tipoEmpresa;
		this.fax = fax;
		this.sitioWeb = sitioWeb;
		this.direccion = direccion;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public SectorLaboral getSector() {
		return sector;
	}

	public void setSector(SectorLaboral sector) {
		this.sector = sector;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public TipoEmpresaEnum getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresaEnum tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return nit+" - "+razonSocial;
	}

	
	
	
}

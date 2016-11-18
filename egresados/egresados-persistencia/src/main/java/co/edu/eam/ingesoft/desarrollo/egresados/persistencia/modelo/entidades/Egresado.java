package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.GeneroEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoCorreoEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoDocumentoEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoTelefonoEnum;

@Entity
@Table(name = "T_EGRESADO")
@NamedQueries(
        {@NamedQuery(name = Egresado.LISTAR_EGRESADOS_POR_EMPRESA, query = "SELECT e FROM HistorialLaboral hl JOIN hl.egresado il JOIN il.egresado e where hl.empresa=?1")
        })
public class Egresado implements Serializable {

	public static final String LISTAR_EGRESADOS_POR_EMPRESA="Egresado.listarEgresadosPorPais";
	
	@Id
	@Column(name = "CED_EGRESADO", nullable = false)
	private String cedula;

	@JoinColumn(name = "ID_PROGRAMA", nullable = false)
	@ManyToOne
	private Programa programa;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "PRIMER_APELLIDO", nullable = false)
	private String primerApellido;

	@Column(name = "SEGUNDO_APELLIDO", nullable = false)
	private String segundoApellido;

	@Column(name = "TIPO_DOCUMENTO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDocumentoEnum tipoDocumento;

	@Column(name = "GENERO", nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "TIPO_EMAIL", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCorreoEnum tipoEmail;

	@Column(name = "TELEFONO", nullable = false)
	private String telefono;

	@Column(name = "TIPO_TELEFONO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoTelefonoEnum tipoTelefono;

	@OneToOne(mappedBy = "egresado", cascade = CascadeType.ALL)
	private InformacionAcademica infoAcademica;

	@OneToOne(mappedBy = "egresado",cascade = CascadeType.ALL)
	private InformacionLaboral infoLaboral;

	public Egresado() {
		super();
	}

	/**
	 * @param cedula
	 * @param programa
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @param tipoDocumento
	 * @param genero
	 * @param email
	 * @param tipoEmail
	 * @param telefono
	 * @param tipoTelefono
	 * @param infoAcademica
	 * @param infoLaboral
	 */
	public Egresado(String cedula,Programa programa, String nombre, String primerApellido, String segundoApellido,
			TipoDocumentoEnum tipoDocumento, GeneroEnum genero, String email, TipoCorreoEnum tipoEmail, String telefono,
			TipoTelefonoEnum tipoTelefono, InformacionAcademica infoAcademica, InformacionLaboral infoLaboral) {
		super();
		this.cedula = cedula;
		this.programa = programa;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoDocumento = tipoDocumento;
		this.genero = genero;
		this.email = email;
		this.tipoEmail = tipoEmail;
		this.telefono = telefono;
		this.tipoTelefono = tipoTelefono;
		this.infoAcademica = infoAcademica;
		this.infoLaboral = infoLaboral;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the programa
	 */
	public Programa getPrograma() {
		return programa;
	}

	/**
	 * @param programa
	 *            the programa to set
	 */
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @param primerApellido
	 *            the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param segundoApellido
	 *            the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return the tipoDocumento
	 */
	public TipoDocumentoEnum getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento
	 *            the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the genero
	 */
	public GeneroEnum getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tipoEmail
	 */
	public TipoCorreoEnum getTipoEmail() {
		return tipoEmail;
	}

	/**
	 * @param tipoEmail
	 *            the tipoEmail to set
	 */
	public void setTipoEmail(TipoCorreoEnum tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the tipoTelefono
	 */
	public TipoTelefonoEnum getTipoTelefono() {
		return tipoTelefono;
	}

	/**
	 * @param tipoTelefono
	 *            the tipoTelefono to set
	 */
	public void setTipoTelefono(TipoTelefonoEnum tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	/**
	 * @return the infoAcademica
	 */
	public InformacionAcademica getInfoAcademica() {
		return infoAcademica;
	}

	/**
	 * @param infoAcademica
	 *            the infoAcademica to set
	 */
	public void setInfoAcademica(InformacionAcademica infoAcademica) {
		this.infoAcademica = infoAcademica;
	}

	/**
	 * @return the infoLaboral
	 */
	public InformacionLaboral getInfoLaboral() {
		return infoLaboral;
	}

	/**
	 * @param infoLaboral
	 *            the infoLaboral to set
	 */
	public void setInfoLaboral(InformacionLaboral infoLaboral) {
		this.infoLaboral = infoLaboral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Egresado other = (Egresado) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

}

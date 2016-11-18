package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.SituacionLaboralEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoEmpresaEnum;

@Entity
@Table(name = "T_INFO_LABORAL")
@NamedQueries({
		@NamedQuery(name = InformacionLaboral.LISTAR_INFORMACION_LABORAL, query = "SELECT il FROM InformacionLaboral il"),
		@NamedQuery(name = InformacionLaboral.LISTAR_INFORMACION_LABORAL_PROGRAMA, query = "SELECT il FROM InformacionLaboral il JOIN il.egresado e WHERE e.programa=?1")
})
public class InformacionLaboral implements Serializable {

	public static final String LISTAR_INFORMACION_LABORAL = "InformacionLaboral.listarInformacionLaboral";
	
	public static final String LISTAR_INFORMACION_LABORAL_PROGRAMA = "InformacionLaboral.listarInformacionLaboralPrograma";

	@Id
	@Column(name = "CED_EGRESADO")
	private String cedEgresado;

	@Column(name = "SITUACION_ACTUAL")
	@Enumerated(EnumType.STRING)
	private SituacionLaboralEnum situacionAct;// (desempleado,empleado,independiente,empresario)

	@Column(name = "TIPO_EMPRESA")
	@Enumerated(EnumType.STRING)
	private TipoEmpresaEnum tipoEmpresa; // (publica,privada)

	@JoinColumn(name = "SECTOR_LABORAL")
	@ManyToOne
	private SectorLaboral sectLaboral;

	@Column(name = "NOM_EMPRESA")
	private String nomEmpresa;

	@Column(name = "FECHA_INGRESO")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;

	@Column(name = "FECHA_SALIDA")
	@Temporal(TemporalType.DATE)
	private Date fechaSalida;

	@Column(name = "CARGO_EMPRESA")
	private String cargoEmpresa;

	@OneToOne(cascade = {})
	@MapsId
	@JoinColumn(name = "CED_EGRESADO", insertable = false, updatable = false)
	private Egresado egresado;

	public InformacionLaboral() {
		super();
	}

	/**
	 * @param cedEgresado
	 * @param situacionAct
	 * @param tipoEmpresa
	 * @param sectLaboral
	 * @param nomEmpresa
	 * @param fechaIngreso
	 * @param fechaSalida
	 * @param cargoEmpresa
	 */
	public InformacionLaboral(String cedEgresado, SituacionLaboralEnum situacionAct, TipoEmpresaEnum tipoEmpresa,
			SectorLaboral sectLaboral, String nomEmpresa, Date fechaIngreso, Date fechaSalida, String cargoEmpresa) {
		super();
		this.cedEgresado = cedEgresado;
		this.situacionAct = situacionAct;
		this.tipoEmpresa = tipoEmpresa;
		this.sectLaboral = sectLaboral;
		this.nomEmpresa = nomEmpresa;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cargoEmpresa = cargoEmpresa;
	}

	/**
	 * @return the cedEgresado
	 */
	public String getCedEgresado() {
		return cedEgresado;
	}

	/**
	 * @param cedEgresado
	 *            the cedEgresado to set
	 */
	public void setCedEgresado(String cedEgresado) {
		this.cedEgresado = cedEgresado;
	}

	/**
	 * @return the situacionAct
	 */
	public SituacionLaboralEnum getSituacionAct() {
		return situacionAct;
	}

	/**
	 * @param situacionAct
	 *            the situacionAct to set
	 */
	public void setSituacionAct(SituacionLaboralEnum situacionAct) {
		this.situacionAct = situacionAct;
	}

	/**
	 * @return the tipoEmpresa
	 */
	public TipoEmpresaEnum getTipoEmpresa() {
		return tipoEmpresa;
	}

	/**
	 * @param tipoEmpresa
	 *            the tipoEmpresa to set
	 */
	public void setTipoEmpresa(TipoEmpresaEnum tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	/**
	 * @return the sectLaboral
	 */
	public SectorLaboral getSectLaboral() {
		return sectLaboral;
	}

	/**
	 * @param sectLaboral
	 *            the sectLaboral to set
	 */
	public void setSectLaboral(SectorLaboral sectLaboral) {
		this.sectLaboral = sectLaboral;
	}

	/**
	 * @return the nomEmpresa
	 */
	public String getNomEmpresa() {
		return nomEmpresa;
	}

	/**
	 * @param nomEmpresa
	 *            the nomEmpresa to set
	 */
	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso
	 *            the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida
	 *            the fechaSalida to set
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return the cargoEmpresa
	 */
	public String getCargoEmpresa() {
		return cargoEmpresa;
	}

	/**
	 * @param cargoEmpresa
	 *            the cargoEmpresa to set
	 */
	public void setCargoEmpresa(String cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}

	/**
	 * @return the egresado
	 */
	public Egresado getEgresado() {
		return egresado;
	}

	/**
	 * @param egresado
	 *            the egresado to set
	 */
	public void setEgresado(Egresado egresado) {
		this.egresado = egresado;
	}

}

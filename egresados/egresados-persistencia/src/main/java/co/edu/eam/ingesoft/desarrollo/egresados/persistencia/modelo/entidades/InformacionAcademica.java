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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.MaximoNivelEduEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.MesEnum;

@Entity
@Table(name="T_INFO_ACADEMICA")
public class InformacionAcademica implements Serializable{

	@Id
	@Column(name="CED_EGRESADO")
	private String cedEgresado;
	
	@JoinColumn(name="COD_FACULTAD",nullable=false)
	@ManyToOne
	private Facultad facultad;
	
	@JoinColumn(name="COD_PROGRAMA",nullable=false)
	@ManyToOne
	private Programa programa;
	
	@Column(name="NIVEL_ACADEMICO")
	private String nivelAcademico; //(Diplomado,pregrado,postgrado)
	
	@Column(name="FECHA_GRADO",nullable=false)
	private int fechaGrado;
	
	@Column(name="MES_GRADO",nullable=false)
	@Enumerated(EnumType.STRING)
	private MesEnum mesGrado;
	
	@Column(name="NUMERO_DIPLOMA",nullable=false)
	private String numeroDiploma;
	
	@Column(name="MAXIMO_NIVEL_EDU",nullable=false)
	@Enumerated(EnumType.STRING)
	private MaximoNivelEduEnum maximoNivelEducativo;
	
	@OneToOne(cascade = {})
	@JoinColumn(name="CED_EGRESADO",insertable=false,updatable=false)
	@MapsId
	private Egresado egresado;

	public InformacionAcademica() {
		super();
	}

	

	/**
	 * @param cedEgresado
	 * @param facultad
	 * @param programa
	 * @param nivelAcademico
	 * @param fechaGrado
	 * @param mesGrado
	 * @param numeroDiploma
	 * @param maximoNivelEducativo
	 */
	public InformacionAcademica(String cedEgresado, Facultad facultad, Programa programa, String nivelAcademico,
			int fechaGrado, MesEnum mesGrado, String numeroDiploma, MaximoNivelEduEnum maximoNivelEducativo) {
		super();
		this.cedEgresado = cedEgresado;
		this.facultad = facultad;
		this.programa = programa;
		this.nivelAcademico = nivelAcademico;
		this.fechaGrado = fechaGrado;
		this.mesGrado = mesGrado;
		this.numeroDiploma = numeroDiploma;
		this.maximoNivelEducativo = maximoNivelEducativo;
	}



	/**
	 * @return the cedEgresado
	 */
	public String getCedEgresado() {
		return cedEgresado;
	}

	/**
	 * @param cedEgresado the cedEgresado to set
	 */
	public void setCedEgresado(String cedEgresado) {
		this.cedEgresado = cedEgresado;
	}

	/**
	 * @return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the programa
	 */
	public Programa getPrograma() {
		return programa;
	}

	/**
	 * @param programa the programa to set
	 */
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	/**
	 * @return the nivelAcademico
	 */
	public String getNivelAcademico() {
		return nivelAcademico;
	}

	/**
	 * @param nivelAcademico the nivelAcademico to set
	 */
	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	/**
	 * @return the fechaGrado
	 */
	public int getFechaGrado() {
		return fechaGrado;
	}

	/**
	 * @param fechaGrado the fechaGrado to set
	 */
	public void setFechaGrado(int fechaGrado) {
		this.fechaGrado = fechaGrado;
	}

	/**
	 * @return the mesGrado
	 */
	public MesEnum getMesGrado() {
		return mesGrado;
	}

	/**
	 * @param mesGrado the mesGrado to set
	 */
	public void setMesGrado(MesEnum mesGrado) {
		this.mesGrado = mesGrado;
	}

	/**
	 * @return the numeroDiploma
	 */
	public String getNumeroDiploma() {
		return numeroDiploma;
	}

	/**
	 * @param numeroDiploma the numeroDiploma to set
	 */
	public void setNumeroDiploma(String numeroDiploma) {
		this.numeroDiploma = numeroDiploma;
	}

	/**
	 * @return the maximoNivelEducativo
	 */
	public MaximoNivelEduEnum getMaximoNivelEducativo() {
		return maximoNivelEducativo;
	}

	/**
	 * @param maximoNivelEducativo the maximoNivelEducativo to set
	 */
	public void setMaximoNivelEducativo(MaximoNivelEduEnum maximoNivelEducativo) {
		this.maximoNivelEducativo = maximoNivelEducativo;
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

	

	
	
}

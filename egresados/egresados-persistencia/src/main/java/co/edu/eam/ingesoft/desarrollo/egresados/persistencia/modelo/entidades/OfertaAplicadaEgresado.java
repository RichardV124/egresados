package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(OfertaAplicadaPK.class)
@Table(name="T_OFERTAAPLICADA_EGRE")
public class OfertaAplicadaEgresado implements Serializable{

	@Id
	@JoinColumn(name="CED_EGRESADO",nullable=false)
	@ManyToOne
	private Egresado egresado;
	
	@Id
	@JoinColumn(name="ID_OFERTA",nullable=false)
	@ManyToOne
	private OfertaLaboral oferta;

	public OfertaAplicadaEgresado() {
		super();
	}
	
	
	
}

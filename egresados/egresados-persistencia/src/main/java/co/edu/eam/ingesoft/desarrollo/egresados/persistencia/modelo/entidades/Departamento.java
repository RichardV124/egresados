package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="T_DEPARTAMENTO")
@NamedQueries(
        {@NamedQuery(name = Departamento.LISTAR_DEPARTAMENTOS_POR_PAIS, query = "SELECT depto FROM Departamento depto WHERE depto.pais=?1")
        })
public class Departamento implements Serializable{

	public static final String LISTAR_DEPARTAMENTOS_POR_PAIS="Departamento.listarDepartamentosPorPais";
    
	
	@Id
	@Column(name="ID_DEPARTAMENTO",nullable=false)
	private int id;
	
	@JoinColumn(name="ID_PAIS",nullable=false)
	@ManyToOne
	private Pais pais;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;

	public Departamento() {
		super();
	}

	
	public Departamento(Pais pais, String nombre) {
		super();
		this.pais = pais;
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return nombre;
	}	
	
	
	
	
}

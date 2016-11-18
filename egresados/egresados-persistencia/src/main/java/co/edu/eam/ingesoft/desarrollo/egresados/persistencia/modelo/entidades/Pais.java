package co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="T_PAIS")
@NamedQueries({
    @NamedQuery(name = Pais.CONSULTA_LISTAR_PAISES, query = "SELECT p FROM Pais p")
})
public class Pais implements Serializable{

	public static final String CONSULTA_LISTAR_PAISES = "Pais.listarPaises";
	
	@Id
	@Column(name="ID_PAIS",nullable=false)
	private int id;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	
	public Pais() {
		super();
	}

	public Pais(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString(){
		return nombre;
	}
	
}

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
@Table(name="T_PROGRAMA")
@NamedQueries({
    @NamedQuery(name = Programa.CONSULTA_LISTAR_PROGRAMAS_POR_FACULTAD, query = "SELECT pro FROM Programa pro WHERE pro.facultad.codigo=?1"),
    @NamedQuery(name = Programa.CONSULTA_LISTAR_PROGRAMAS, query = "SELECT pro FROM Programa pro")
})
public class Programa implements Serializable {

	public static final String CONSULTA_LISTAR_PROGRAMAS_POR_FACULTAD = "Programa.listarProgramasPorFacultad";
	
	public static final String CONSULTA_LISTAR_PROGRAMAS = "Programa.listarProgramas";
	
	@Id
	@Column(name="COD_PROGRAMA",nullable=false)
	private String codigo;
	
	@JoinColumn(name="COD_FACULTAD",nullable=false)
	@ManyToOne
	private Facultad facultad;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION",nullable=false)
	private String descripcion;

	public Programa() {
		super();
	}

	public Programa(String codigo, Facultad facultad, String nombre,String descripcion) {
		super();
		this.codigo = codigo;
		this.facultad = facultad;
		this.nombre = nombre;
		this.descripcion=descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString(){
		return codigo + " - " + nombre;
	}
		
}

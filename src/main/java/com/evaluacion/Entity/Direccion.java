package com.evaluacion.Entity;

import javax.persistence.*;
/**
 * @author jorge
 *
 */
@Entity
@Table
public class Direccion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int id;
	private String codigoPostal;
	private String estado;
	
	@Transient
	@OneToOne(cascade= {CascadeType.ALL})
	private Usuario usuario;
	
	
	public Direccion(int id, String codigoPostal, String estado) {
		this.id = id;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
	}
	public Direccion() {};
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Direccion other = (Direccion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", usuario=" + usuario
				+ "]";
	}
	
	
	
}

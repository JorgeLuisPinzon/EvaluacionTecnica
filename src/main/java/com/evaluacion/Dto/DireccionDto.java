package com.evaluacion.Dto;

import javax.persistence.Transient;

import com.evaluacion.Entity.Usuario;
/**
 * @author jorge
 *
 */
public class DireccionDto {
	
	public DireccionDto(int id,String codigoPostal, String estado) {
	
		this.id = id;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
	}
	public DireccionDto() {};
	@Transient
	private int id;
	
	private String codigoPostal;
	
	private String estado;
	@Transient
	private Usuario usuario;
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
	
}

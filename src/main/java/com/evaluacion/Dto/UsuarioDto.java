
package com.evaluacion.Dto;


import javax.validation.constraints.NotEmpty;


/**
 * @author jorge
 *
 */

public class UsuarioDto {
	
	public UsuarioDto(int id, String nombre,String apellidoPaterno,
			String apellidoMaterno, String fechaNacimiento,  CuentaDto cuenta,
			DireccionDto direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.cuenta = cuenta;
		this.direccion = direccion;
	}
 public UsuarioDto() {};
 
	private int id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellidoPaterno;
	@NotEmpty
	private String apellidoMaterno;
	@NotEmpty
	private String fechaNacimiento;
	
	private CuentaDto cuenta;

	private DireccionDto direccion;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the cuenta
	 */
	public CuentaDto getCuenta() {
		return cuenta;
	}
	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(CuentaDto cuenta) {
		this.cuenta = cuenta;
	}
	/**
	 * @return the direccion
	 */
	public DireccionDto getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(DireccionDto direccion) {
		this.direccion = direccion;
	}
	
	
}

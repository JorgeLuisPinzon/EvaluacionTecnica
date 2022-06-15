package com.evaluacion.Dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.NumberFormat;

import com.evaluacion.Entity.Usuario;

/**
 * @author jorge
 *
 */
public class CuentaDto {
	
	public CuentaDto(int id, int numeroCuenta,
			 float ingresos) {
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.ingresos = ingresos;
	}
	public CuentaDto() {};
	@Transient
	private int id;
	@NotEmpty
	private int numeroCuenta;
    @NumberFormat(style=NumberFormat.Style.CURRENCY)
	private float ingresos;
	@Transient
	private Usuario usuario;
	/**
	 * @return the numeroCuenta
	 */
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	/**
	 * @return the ingresos
	 */
	public float getIngresos() {
		return ingresos;
	}
	/**
	 * @param ingresos the ingresos to set
	 */
	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
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

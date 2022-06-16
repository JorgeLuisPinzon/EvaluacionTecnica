/**
 * 
 */
package com.evaluacion.Entity;

import javax.persistence.*;


/**
 * @author jorge
 *
 */
@Embeddable
@Entity
@Table(name="Cuentas")
public class Cuenta {
	
	@Id
	private int id;

	private int numeroCuenta;
	
	private float ingresos;
	@Transient
	@OneToOne(cascade= {CascadeType.ALL})
	private Usuario usuario;
	
	
	public Cuenta(int id, int numeroCuenta, float ingresos) {
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.ingresos = ingresos;
	}
public Cuenta() {};
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
		Cuenta other = (Cuenta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", numeroCuenta=" + numeroCuenta + ", ingresos=" + ingresos + ", usuario=" + usuario
				+ "]";
	}
	
	
}

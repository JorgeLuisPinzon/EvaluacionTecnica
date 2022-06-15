/**
 * 
 */
package com.evaluacion.CustomExceptions;

/**
 * @author jorge
 *
 */
public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	
	
	public CustomException(String mensaje) {
		this.mensaje = mensaje;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.mensaje;
	}
	
}

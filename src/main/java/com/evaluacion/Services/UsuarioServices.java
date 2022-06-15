/**
 * 
 */
package com.evaluacion.Services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.evaluacion.Dto.UsuarioDto;
import com.evaluacion.Entity.Usuario;

/**
 * @author jorge
 *
 */
@Component
public interface UsuarioServices {

	public Usuario crearUsuario(UsuarioDto usuario);
	
	public Usuario seleccionarUsuario(int idUsuario);
	
	public List<Usuario> seleccionarTodo();

	public Usuario actualizarUsuario(UsuarioDto usuario,int idUsuario);
	
	public void eliminarUsuario(int idUsuario);
		
	public String validarDatos(String fecha,float ingreso,String numCta,String codPostal) ;

}

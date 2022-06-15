package com.evaluacion.Controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.evaluacion.CustomExceptions.CustomException;
import com.evaluacion.Dto.*;
import com.evaluacion.Entity.*;
import com.evaluacion.Services.*;
import com.evaluacion.Utils.AplicationConstants;


/**
 * @author jorge
 *
 */
@RestController
@RequestMapping("/evaluacion")
public class Controlador {
	@Autowired
	UsuarioServices service;
	
	private Map<String,Object> mapMessage=null;

	@SuppressWarnings("rawtypes")
	@PostMapping("/crearUsuario")
	public ResponseEntity<?> crearUsuario(@Valid @RequestBody UsuarioDto usuario) {
		String resp = service. validarDatos(usuario.getFechaNacimiento(),
								usuario.getCuenta().getIngresos(),
								String.valueOf(usuario.getCuenta().getNumeroCuenta()),
								usuario.getDireccion().getCodigoPostal());
		if(resp!=null) {
			mapMessage =new HashMap<>();
			mapMessage.put("message", resp);
			return new ResponseEntity<Map> (mapMessage, HttpStatus.OK);
		}
			else
			return new ResponseEntity<>(service.crearUsuario(usuario),HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/seleccionarUsuario/{id}")
	public ResponseEntity<?> seleccionarUsuario(@PathVariable(required = true, name="id")  int idUsuario) {
		if( idUsuario <=0 ) {
			mapMessage =new HashMap<>();
			mapMessage.put("message", AplicationConstants.C_ID_INVALIDO);
			return new ResponseEntity<Map> (mapMessage, HttpStatus.OK);
		}else
			return new ResponseEntity<>(service.seleccionarUsuario(idUsuario), HttpStatus.OK);
	}
	@SuppressWarnings("rawtypes")
	@GetMapping("/seleccionarTodo")
	public ResponseEntity<?> seleccionarTodo() {
		List<Usuario> datos= service.seleccionarTodo();
		if( datos.isEmpty() ) {
			mapMessage =new HashMap<>();
			mapMessage.put("message", AplicationConstants.C_DATO_NO_ENCONTRADO);
			return new ResponseEntity<Map> (mapMessage, HttpStatus.OK);
		}else
			return new ResponseEntity<>(datos, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/editarUsuario/{id}")
	public ResponseEntity<?> editarUsuario (@PathVariable(required = true, name="id")  int idUsuario, @Valid @RequestBody UsuarioDto usuario) {
		if( idUsuario <=0 ) {
			mapMessage =new HashMap<>();
			mapMessage.put("message", AplicationConstants.C_ID_INVALIDO);
			return new ResponseEntity<Map> (mapMessage, HttpStatus.OK);
		}else
			return new ResponseEntity<>(service.actualizarUsuario(usuario,idUsuario), HttpStatus.OK);		
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/eliminarUsuario/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable(required = true, name="id")  int idUsuario) {
		mapMessage =new HashMap<>();
		try {
		if(idUsuario<=0) 
			mapMessage.put("message", AplicationConstants.C_ID_INVALIDO);
		else { 
			service.eliminarUsuario(idUsuario);
			mapMessage.put("message", " Usuario con ID : "+idUsuario+" Fue Eliminado con Exito");
			}
		}catch(Exception e) {
			throw new CustomException(e.getMessage());
		}

		return new ResponseEntity<Map> (mapMessage, HttpStatus.OK);
	}

}

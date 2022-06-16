package com.evaluacion.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.CustomExceptions.CustomException;
import com.evaluacion.Dto.UsuarioDto;
import com.evaluacion.Entity.Cuenta;
import com.evaluacion.Entity.Direccion;
import com.evaluacion.Entity.Usuario;
import com.evaluacion.Repository.UsuarioRepositorio;
import com.evaluacion.Utils.AplicationConstants;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UsuarioServicesImp implements UsuarioServices{
	
	@Autowired
	UsuarioRepositorio repositorioUsuario;
	private static byte id_new=0;
	
	@Override
	public Usuario crearUsuario(UsuarioDto usuario) {
		// TODO Auto-generated method stub
		id_new++;
		Usuario user = convertirObjectSerializable(usuario, id_new);
		return repositorioUsuario.save(user);
	}

	@Override
	public Usuario seleccionarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = repositorioUsuario.findById(idUsuario);
		if (!usuario.isPresent())
			throw new CustomException(AplicationConstants.C_DATO_NO_ENCONTRADO);

		return usuario.get();

	}
	
	@Override
	public List<Usuario> seleccionarTodo() {
		List<Usuario> res = new ArrayList<Usuario>();
		Iterable<Usuario> usuarios = repositorioUsuario.findAll();
		for (Usuario us : usuarios)
			res.add(us);

		return res;
	}
	@Override
	public Usuario actualizarUsuario(UsuarioDto usuario, int idUsuario) {
		try {

			usuario.setId(idUsuario);
			Usuario usuarioAux = repositorioUsuario.findById(idUsuario).get();

			if (usuarioAux != null) {
				Usuario newEntity = convertirObjectSerializable(usuario, idUsuario);
				return repositorioUsuario.save(newEntity);
			} else
				throw new CustomException(AplicationConstants.C_DATO_NO_ENCONTRADO);

		} catch (Exception e) {
			throw new CustomException(AplicationConstants.C_ERROR_UPDATE + usuario.getId());
		}
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		try {
			Usuario usuario = repositorioUsuario.findById(idUsuario).get();

			if (usuario != null)
				repositorioUsuario.delete(usuario);
			else
				throw new CustomException(AplicationConstants.C_DATO_NO_ENCONTRADO);

		} catch (Exception e) {
			throw new CustomException(AplicationConstants.C_ERROR_DELETE + idUsuario);
		}
	}
	
	private HashMap<String, Object> convertirRequestToString(UsuarioDto usuario) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("id", usuario.getId());
		result.put("nombre", usuario.getNombre());
		result.put("apellidoPaterno", usuario.getApellidoPaterno());
		result.put("apellidoMaterno", usuario.getApellidoMaterno());
		result.put("fechaNacimiento", usuario.getFechaNacimiento());
		result.put("cuenta", usuario.getCuenta());
		result.put("direccion", usuario.getDireccion());
		return result;
	}
	
	private boolean validarFormatoFecha(String strDate) {
		 SimpleDateFormat formatoFecha = new SimpleDateFormat(AplicationConstants.C_FECHA_FORMAT_1);
		 formatoFecha.setLenient(false);
		 String [] fechaArray=strDate.split("/");
			try {
				if(fechaArray[0].length()!=2 || fechaArray[1].length()!=2||fechaArray[2].length()!=4 )
					return false;
				int dia = Integer.valueOf(fechaArray[0]);
				int mes = Integer.valueOf(fechaArray[1]);
				int anio = Integer.valueOf(fechaArray[2]);
				formatoFecha.parse(dia + "/" + mes + "/" + anio);
				return true;
			} catch (ParseException e) {
				return false;
			}
	}
	
	private Usuario convertirObjectSerializable(UsuarioDto usuario, int idUsuario) {
		Usuario newEntity;
		try {
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, Object> finalHashMap;
			finalHashMap = convertirRequestToString(usuario);
			mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			newEntity = mapper.convertValue(finalHashMap, Usuario.class);
			Cuenta ctaNew = newEntity.getCuenta();
			ctaNew.setId(idUsuario);
			Direccion direccionNew = newEntity.getDireccion();
			direccionNew.setId(idUsuario);
			newEntity.setCuenta(ctaNew);
			newEntity.setDireccion(direccionNew);
		} catch (Exception e) {
			throw new CustomException(AplicationConstants.C_DATO_NO_ENCONTRADO);
		}
		return newEntity;
	}
	
	public String validarDatos(String fecha,float ingreso,String numCta,String codPostal) {
		String respuestaValida = null;
		try {
		
		if(!validarFormatoFecha(fecha)) 
			respuestaValida = AplicationConstants.C_FECHA_FORMAT_INVALIDO;

		String floatString = String.valueOf(ingreso);	
		if(!floatString.contains(".")) 
			respuestaValida = AplicationConstants.C_INGRESO_FORMAT_INVALIDO;
		if(ingreso>0.0f) { 
			String decimal = floatString.substring(floatString.indexOf("."), floatString.length())  ;
			if (decimal.contains("0"))
				respuestaValida = AplicationConstants.C_INGRESO_FORMAT_DECIMALES;	
			try{
			Float.parseFloat(floatString); 
			}catch(NumberFormatException e){respuestaValida = AplicationConstants.C_INGRESO_FORMAT_INVALIDO;} 
			}else
				respuestaValida = AplicationConstants.C_INGRESO_FORMAT_MAYOR_0;
		if(numCta.length()!=10) {respuestaValida = AplicationConstants.C_NUMBER_CTA_FORMAT_10_DIG; }
		if(codPostal.length()!=6) {respuestaValida = AplicationConstants.C_COD_POSTAL_FORMAT_6_DIG; }
		
		}catch(Exception e) {
			respuestaValida = e.getMessage();
		}
		
		return respuestaValida;
	}
	
}

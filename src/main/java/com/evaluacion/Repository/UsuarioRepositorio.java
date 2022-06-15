/**
 * 
 */
package com.evaluacion.Repository;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.evaluacion.Entity.Usuario;

/**
 * @author jorge
 *
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {



}

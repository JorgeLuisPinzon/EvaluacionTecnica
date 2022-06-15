/**
 * 
 */
package com.evaluacion.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author jorge
 *
 */
@ControllerAdvice
@RestController
public class CustomExceptionResponse extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public final ResponseEntity<?> handlerCrudOperationException(CustomException ce,WebRequest wr){
		return new ResponseEntity<Object> (ce,HttpStatus.BAD_REQUEST);
	}
}

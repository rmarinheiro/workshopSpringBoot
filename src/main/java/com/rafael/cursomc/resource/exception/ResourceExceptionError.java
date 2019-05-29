package com.rafael.cursomc.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.rafael.cursomc.service.exceptions.ObjectFoundException;

@ControllerAdvice
public class ResourceExceptionError {

	@ExceptionHandler(ObjectFoundException.class)
	public ResponseEntity<StandardException> objectNotFound(ObjectFoundException e , HttpServletRequest request){
		
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardException e1 = new StandardException(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(e1);
		
	}
}

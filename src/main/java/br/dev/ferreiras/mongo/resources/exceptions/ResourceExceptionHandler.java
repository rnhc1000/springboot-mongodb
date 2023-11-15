package br.dev.ferreiras.mongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.dev.ferreiras.mongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(), "Not Found",
				ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(standardError);
	}

}

package br.com.sbr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundOperacaoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundOperacaoException(String exception) {
		super(exception);
	}

}

package br.com.tecommerce.api.controller.error;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.tcommerce.domain.DomainBusinessException;

@ControllerAdvice
public class HttpErrorExceptionHandler {

	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler(DomainBusinessException.class)
	@ResponseBody
	public Erro erroRegraDeNegocio(DomainBusinessException e) {

		return new Erro(e.getMessage());
	}

}

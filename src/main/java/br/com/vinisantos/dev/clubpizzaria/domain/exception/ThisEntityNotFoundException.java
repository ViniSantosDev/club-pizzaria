package br.com.vinisantos.dev.clubpizzaria.domain.exception;

public class ThisEntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ThisEntityNotFoundException(String msg) {
		super(msg);
	}

}

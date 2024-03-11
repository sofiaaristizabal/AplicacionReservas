package application.exceptions;

public class ContratoNotFoundException extends Exception {

	public ContratoNotFoundException (String codigo) {
		super("El contrato de codigo " + codigo + " no fue encontrado");
	}
}

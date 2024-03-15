package application.backend;

public class ContratoNoPermitidoException extends Exception {

	public ContratoNoPermitidoException() {
		System.out.println("No se puede generar un contrato en una reserva de visita ");
	}
}

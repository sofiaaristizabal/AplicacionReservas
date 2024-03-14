package application.exceptions;

public class ReservaNotFoundException extends Exception {

	public ReservaNotFoundException(String codigo) {
		super("No encuentra la reserva con codigo: " + codigo );
	}
}

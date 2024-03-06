package application.exceptions;

public class TipoReservaDoesNotExistException extends Exception {
	public TipoReservaDoesNotExistException(String arg) {
		super("No encuentra reserva con tipo" + arg);
	}
}

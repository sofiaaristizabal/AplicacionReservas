package application.exceptions;

public class UsuarioNotFoundException extends Exception{
	public UsuarioNotFoundException(String arg) {
		super("No encuentra usuario con cedula:" + arg);
	}
}

package application.exceptions;

public class LugarNotFoundException extends Exception {

	public LugarNotFoundException(String nombre) {
		super("No encuentro el lugar de evento: " + nombre );
	}

}

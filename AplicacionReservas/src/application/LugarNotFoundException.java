package application;

public class LugarNotFoundException extends Exception {

	public LugarNotFoundException(String nombre) {
		super("No encuentro el lugar de evento: " + nombre );
	}

}

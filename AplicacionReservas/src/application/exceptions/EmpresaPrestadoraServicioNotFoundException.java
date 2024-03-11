package application.exceptions;

public class EmpresaPrestadoraServicioNotFoundException extends Exception {

	public EmpresaPrestadoraServicioNotFoundException(String nombre) {
		
		System.out.println("No se ha encontrado la empresa con nombre: " + nombre);
	}
}

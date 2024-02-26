package application;
import java.util.Date;

public class ReservaLugar extends Reserva {
	
	private int cantidadPersonas;

	public ReservaLugar(String codigo, String lugarEvento, Date fechaReserva,
			int cantidadPersonas) {
		super(codigo, lugarEvento, fechaReserva);
		this.cantidadPersonas = cantidadPersonas;
	}
	
	
	
	

}

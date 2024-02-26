package application;
import java.util.Date;

public class ReservaVisita extends Reserva {
	
	private double tiempoVisita;
	private String hora;
	
	
	public ReservaVisita(String codigo, String lugarEvento, Date fechaReserva,
			double tiempoVisita, String hora) {
		super(codigo, lugarEvento, fechaReserva);
		this.tiempoVisita = tiempoVisita;
		this.hora = hora;
	}
	
	

}

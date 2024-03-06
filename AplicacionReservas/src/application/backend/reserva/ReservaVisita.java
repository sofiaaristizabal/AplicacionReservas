package application.backend.reserva;
import java.time.LocalDate;
import java.util.Date;

import application.backend.LugarDeEvento;

public class ReservaVisita extends Reserva {
	
	private double tiempoVisita;
	private String hora;
	
	
	public ReservaVisita(LugarDeEvento lugarEvento, LocalDate fechaReserva, String hora) {
		super(lugarEvento, fechaReserva);
		this.hora = hora;
	}
	
	

}

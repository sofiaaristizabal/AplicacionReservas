package application.backend.reserva;
import java.time.LocalDate;
import java.util.Date;

import application.backend.LugarDeEvento;

public class ReservaLugar extends Reserva {
	
	private int cantidadPersonas;

	public ReservaLugar(LugarDeEvento lugarEvento, LocalDate fechaReserva,
			int cantidadPersonas) {
		super(lugarEvento, fechaReserva);
		this.cantidadPersonas = cantidadPersonas;
	}
	
	
	
	

}

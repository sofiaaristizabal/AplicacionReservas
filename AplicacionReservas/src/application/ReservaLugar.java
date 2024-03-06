package application;
import java.time.LocalDate;
import java.util.Date;

public class ReservaLugar extends Reserva {
	
	private int cantidadPersonas;

	public ReservaLugar(LugarDeEvento lugarEvento, LocalDate fechaReserva,
			int cantidadPersonas) {
		super(lugarEvento, fechaReserva);
		this.cantidadPersonas = cantidadPersonas;
	}
	
	
	
	

}

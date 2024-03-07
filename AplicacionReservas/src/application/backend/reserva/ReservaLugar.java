package application.backend.reserva;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import application.backend.LugarDeEvento;
import application.backend.empresa.EmpresaPrestadoraServicio;

public class ReservaLugar extends Reserva {
	
	private int cantidadPersonas;
	private Contrato[] contratos;

	public ReservaLugar(LugarDeEvento lugarEvento, LocalDate fechaReserva,
			int cantidadPersonas) {
		super(lugarEvento, fechaReserva);
		this.cantidadPersonas = cantidadPersonas;
		contratos = new Contrato[0];
	}
	
	public void agregarContrato(EmpresaPrestadoraServicio empresa, Date fecha, double tarifa) {
		
		Contrato contrato = new Contrato(empresa, fecha, tarifa);
		
		contratos = Arrays.copyOf(contratos,contratos.length+1);
		contratos[contratos.length-1] = contrato;
		
		
	}
	
	

}

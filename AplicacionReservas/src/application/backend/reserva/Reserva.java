package application.backend.reserva;

import java.time.LocalDate;
import java.util.*;

import application.backend.LugarDeEvento;

public abstract class Reserva {
	
	protected String codigo;
	//String de placeholder
	protected LugarDeEvento lugarEvento;
	protected Date fechaGeneracion;
	protected LocalDate fechaReserva;
	
	
	public Reserva(LugarDeEvento lugarEvento, LocalDate fechaReserva) {
		
		this.lugarEvento = lugarEvento;
		this.fechaReserva = fechaReserva;
        generarFecha();
  
	}
  
  
  public void generarFecha() {
  
	  Date d1 = new Date();

		this.fechaGeneracion = d1;
		
  }


	public String getCodigo() {
		return codigo;
	}


	public LugarDeEvento getLugarEvento() {
		return lugarEvento;
	}


	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}


	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	


	
	
	
	

}

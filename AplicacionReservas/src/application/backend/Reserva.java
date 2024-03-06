package application.backend;

import java.util.*;

public abstract class Reserva {
	
	protected String codigo;
	//String de placeholder
	protected String lugarEvento;
	protected Date fechaGeneracion;
	protected Date fechaReserva;
	
	
	public Reserva(String codigo, String lugarEvento, Date fechaReserva) {
		this.codigo = codigo;
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


	public String getLugarEvento() {
		return lugarEvento;
	}


	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}


	public Date getFechaReserva() {
		return fechaReserva;
	}

	


	
	
	
	

}

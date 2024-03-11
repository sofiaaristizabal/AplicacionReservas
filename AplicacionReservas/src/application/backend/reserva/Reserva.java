package application.backend.reserva;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import application.backend.LugarDeEvento;

public abstract class Reserva implements Serializable {
	
	protected String codigo;
	//String de placeholder
	protected LugarDeEvento lugarEvento;
	protected Date fechaGeneracion;
	protected LocalDate fechaReserva;
	
	
	public Reserva(LugarDeEvento lugarEvento, LocalDate fechaReserva) {
		
		this.lugarEvento = lugarEvento;
		this.fechaReserva = fechaReserva;
        generarFecha();
        generarCodigo();
  
	}
  
  
  public void generarFecha() {
  
	  Date d1 = new Date();

		this.fechaGeneracion = d1;
		
  }
  
  public void generarCodigo() {
		
		String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		String code = "";
		
		for(int i = 0; i < 4; i++) {
			
			char caracter = a.charAt((int) (Math.random()*a.length()));
			code.concat(Character.toString(caracter));
		}
		
		this.codigo = code;
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

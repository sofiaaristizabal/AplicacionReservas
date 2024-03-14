package application.backend.reserva;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import application.backend.LugarDeEvento;

public abstract class Reserva implements Serializable {
	
	
	//String de placeholder
	protected LugarDeEvento lugarEvento;
	protected Date fechaGeneracion;
	protected LocalDate fechaReserva;
	protected String password;
	protected StringBuilder codigo;
	
	
	public Reserva(LugarDeEvento lugarEvento, LocalDate fechaReserva) {
		
		this.lugarEvento = lugarEvento;
		this.fechaReserva = fechaReserva;
        generarFecha();
        
        generarCodigo();
        System.out.println(codigo);
  
	}
  
  
  public void generarFecha() {
  
	  Date d1 = new Date();

		this.fechaGeneracion = d1;
		
  }
  
  
  public void generarCodigo() {
		
		String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		StringBuilder code = new StringBuilder();//Grandes
		 
        for (int i = 0; i < 4; i++) {
            int indice = (int) (Math.random() * a.length());
            code.append(a.charAt(indice));
        }
		
		this.codigo = code;
	}


	public StringBuilder getCodigo() {
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

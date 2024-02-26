package application;
import java.util.*;

public class Usuario {
	
	private String nombre;
	private int cedula;
	private int edad;
	private int telefono;
	private String correo;
	private double presupuesto;
	private double saldo;
	private Reserva[] reservas = new Reserva[0];
	
	
	
	public Usuario(String nombre, int cedula, int edad, int telefono, String correo, double presupuesto, double saldo) 
	{
		this.nombre = nombre;
		this.cedula = cedula;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.presupuesto = presupuesto;
		this.saldo = saldo;
	}
	
	public void agregarReserva(Reserva e1)
	{
		Reserva nuevaReserva = e1;
		
		reservas = Arrays.copyOf(reservas, reservas.length+1);
		reservas[reservas.length-1] = nuevaReserva;
		
	}
	
	public int buscarReserva(String codigo)
	{
		int i = 0;
		while((i<reservas.length) && !(reservas[i].getCodigo().equals(codigo)) )
		{
			i++;
		}
		
		if(reservas[i].getCodigo().equals(codigo))
		{
			return i;
		}else {
			return -1;
		}
		
	}
	
	
	
	

}

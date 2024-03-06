package application.backend;
import java.time.LocalDate;
import java.util.*;

import application.backend.LugarDeEvento;
import application.backend.reserva.Reserva;
import application.backend.reserva.ReservaLugar;
import application.backend.reserva.ReservaVisita;

public class Usuario {
	
//attributs
	private String nombre;
	private String cedula;
	private int edad;
	private String telefono;
	private String correo;
	private double presupuesto;
	private double saldo;
	private Reserva[] reservas = new Reserva[0];
	
	
	
//constructors
	public Usuario(String nombre, String cedula, int edad, String telefono, String correo, double presupuesto, double saldo) 
	{
		this.nombre = nombre ;
		this.cedula = cedula;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.presupuesto = presupuesto;
		this.saldo = saldo;
	}
	
//accessors
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
//methods
	public void agregarReserva(Reserva e1)
	{
		Reserva nuevaReserva = e1;
		
		reservas = Arrays.copyOf(reservas, reservas.length+1);
		reservas[reservas.length-1] = nuevaReserva;
		
	}
	
	public void agregarReservaLugar(int cantidad, LugarDeEvento e, LocalDate fecha)
	{
		Reserva nuevaReserva = new ReservaLugar(e, fecha, cantidad);
		
		reservas = Arrays.copyOf(reservas, reservas.length+1);
		reservas[reservas.length-1] = nuevaReserva;
		
	}
	
	public void agregarReservaVisita(String hora, LugarDeEvento e, LocalDate fecha)
	{
		Reserva nuevaReserva = new ReservaVisita(e, fecha, hora);
		
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
